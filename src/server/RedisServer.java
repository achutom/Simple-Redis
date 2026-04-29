package src.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RedisServer {

    int port; // Listening port
    public ServerSocket server;
    public Socket client;

    public RedisServer() throws IOException {
        port = 5000;
        server = createServer();
        client = createClient(server);
    }

    // Creates a socket server.
    public ServerSocket createServer() throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port " + port + "!");
        System.out.println("Waiting for a connection...");

        return server;
    }

    // Accepts a client.
    public Socket createClient(ServerSocket server) throws IOException {
        Socket client = server.accept();
        System.out.println("Client is connected.");

        return client;
    }

}
