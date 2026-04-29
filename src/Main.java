package src;

import java.io.IOException;

import src.network.ClientHandler;

public class Main {
    public static void main(String args[]) throws IOException {
        ClientHandler clientHandler = new ClientHandler();

        clientHandler.handleClient();

        System.out.println("Client has disconnected");
    }
}
