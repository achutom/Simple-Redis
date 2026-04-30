package src.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import src.parser.CommandParser;
import src.storage.DataStore;

public class ClientHandler implements Runnable {

    private Socket client;
    String line;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    public void handleClient() throws IOException {
        CommandParser commandParser = new CommandParser();

        DataStore dataStore = new DataStore();

        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        System.out.println("Waiting for input...");

        line = "";

        while ((line = reader.readLine()) != null) {
            String code[] = line.split(" ");

            String response = "";

            response = commandParser.parseCode(code, response, dataStore);

            // Send response to client
            writer.write(response);
            writer.newLine();
            writer.flush();
        }
    }

    @Override
    public void run() {
        try {
            handleClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
