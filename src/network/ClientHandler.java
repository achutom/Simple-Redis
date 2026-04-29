package src.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import src.parser.CommandParser;
import src.server.RedisServer;
import src.storage.DataStore;

public class ClientHandler {

    // public BufferedReader reader;
    // public BufferedWriter writer;
    String line;

    public void handleClient() throws IOException {
        RedisServer redisServer = new RedisServer();

        CommandParser commandParser = new CommandParser();

        DataStore dataStore = new DataStore();

        BufferedReader reader = new BufferedReader(new InputStreamReader(redisServer.client.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(redisServer.client.getOutputStream()));

        System.out.println("Waiting for input...");

        line = "";

        while ((line = reader.readLine()) != null) {
            String code[] = line.split(" ");

            String response = "";

            response = commandParser.parseCode(code, response, dataStore.storage);

            // Send response to client
            writer.write(response);
            writer.newLine();
            writer.flush();
        }
    }
}
