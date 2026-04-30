package src.storage;

import java.util.concurrent.ConcurrentHashMap;

public class DataStore {
    public ConcurrentHashMap<String, String> storage;

    public DataStore() {
        storage = new ConcurrentHashMap<>();
    }
}
