package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Redis {
    public static void main(String args[]) throws IOException {
        int port = 5000;

        // In memory storage
        HashMap<String, String> storage = new HashMap<>();

        ServerSocket server = new ServerSocket(port); // Setting up server
        System.out.println("Server started on port " + port + "!");
        System.out.println("Waiting for a connection...");

        Socket client = server.accept();
        System.out.println("Client is connected.");

        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        String line = "";

        while ((line = reader.readLine()) != null) {
            String code[] = line.split(" ");

            String response = "";

            if (code[0].equalsIgnoreCase("SET") && code.length >= 3) {
                String key = code[1];
                String value = code[2];
                storage.put(key, value);
                response = "New var " + key + " has been set.";
            } else if (code[0].equalsIgnoreCase("GET") && code.length >= 2) {
                String key = code[1];
                response = storage.getOrDefault(key, "undefined");
            } else {
                response = "ERROR";
            }

            // Send response to client
            writer.write(response);
            writer.newLine();
            writer.flush();
        }

        System.out.println("Client has disconnected");
        server.close();
    }
}
