package src.parser;

import java.util.concurrent.ConcurrentHashMap;

public class CommandParser {
    public String parseCode(String code[], String response, ConcurrentHashMap<String, String> storage) {
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

        return response;
    }
}
