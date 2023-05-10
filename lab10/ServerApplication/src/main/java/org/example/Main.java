package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int port = 4000;
        try {
            GameServer server = new GameServer(port);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}