package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String ip = "localhost";
        int port = 4000;
        try {
            GameClient client = new GameClient(ip, port);
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}