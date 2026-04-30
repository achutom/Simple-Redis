package src.parser;

import src.storage.DataStore;

public class CommandParser {
    public String parseCode(String code[], String response, DataStore dataStore) {
        switch (code[0].toUpperCase()) {
            case "SET":
                response = dataStore.set(code[1], code[2]);
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

            default:
                response = "ERROR: UNKNOWN COMMAND";
                break;
        }

        return response;
    }
}
