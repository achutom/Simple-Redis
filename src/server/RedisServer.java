package src.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import src.network.ClientHandler;

public class RedisServer {

    private int port = 5000;
    private ServerSocket server;

    public RedisServer() throws IOException {
        server = new ServerSocket(port);

        System.out.println("Server started on port " + port + "!");
    }

    public void start() throws IOException {

        while (true) {
            System.out.println("Waiting for a connection...");

            Socket client = server.accept();
            System.out.println("Client connected: " + client.getInetAddress());

            ClientHandler handler = new ClientHandler(client);

            ExecutorService pool = Executors.newFixedThreadPool(10);
            pool.execute(handler);
        }
    }
}