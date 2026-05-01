package src.parser;

import java.util.Arrays;

import src.storage.DataStore;

public class CommandParser {
    public String parseCode(String code[], String response, DataStore dataStore) {
        switch (code[0].toUpperCase()) {
            case "SET":
                String value = String.join(" ", Arrays.copyOfRange(code, 2, code.length));
                response = dataStore.set(code[1], value);
                break;
            case "GET":
                response = dataStore.get(code[1]);
                break;
            case "DEL":
                response = dataStore.del(code[1]);
                break;
            case "EXISTS":
                response = dataStore.exists(code[1]);
                break;

            case "KEYS":
                response = dataStore.keys();
                break;

            case "CLEAR":
                response = dataStore.clear();
                break;
            default:
                response = "ERROR: UNKNOWN COMMAND";
                break;
        }

        return response;
    }
}
