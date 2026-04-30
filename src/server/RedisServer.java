package src.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import src.network.ClientHandler;
import src.storage.DataStore;

public class RedisServer {

    private int port = 5000;
    private ServerSocket server;
    private DataStore dataStore;

    public RedisServer() throws IOException {
        server = new ServerSocket(port);
        dataStore = new DataStore();

        System.out.println("Server started on port " + port + "!");
    }

    public void start() throws IOException {

        while (true) {
            System.out.println("Waiting for a connection...");

            Socket client = server.accept();
            System.out.println("Client connected: " + client.getInetAddress());

            ClientHandler handler = new ClientHandler(client, dataStore);

            Thread thread = new Thread(handler);
            thread.start();
        }
    }
}