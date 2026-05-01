package src.storage;

import java.util.concurrent.ConcurrentHashMap;

public class DataStore {
    private ConcurrentHashMap<String, String> storage;

    public DataStore() {
        storage = new ConcurrentHashMap<>();
    }

    // SET Method
    public String set(String key, String value) {
        storage.put(key, value);
        return "New variable " + key + " has been initialized.";
    }

    // GET Method
    public String get(String key) {
        return storage.getOrDefault(key, "undefined");
    }

    // DEL Method
    public String del(String key) {
        if (storage.remove(key) != null) {
            return "Removed " + key + " entry from database.";
        }
        return "No " + key + " entry found in database.";
    }

    // EXISTS Method
    public String exists(String key) {
        if (storage.containsKey(key)) {
            return "Entry " + key + " exists.";
        }
        return "No such entry found.";
    }

    // KEYS Method
    public String keys() {
        return storage.keySet().toString();
    }

    // CLEAR Method
    public String clear() {
        storage.clear();
        return "Cleared all entries in database.";
    }

}
