package src;

import java.io.IOException;
import src.server.RedisServer;

public class Main {
    public static void main(String args[]) throws IOException {
        RedisServer redisServer = new RedisServer();

        redisServer.start();

        System.out.println("Client has disconnected");
    }
}
