package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private int port;
    private ServerSocket serverSocket;

    public GameServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started at port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            ClientThread clientThread = new ClientThread(socket, this);
            clientThread.start();
            System.out.println("new client");
        }
    }

    public void stop() throws IOException {

        System.out.println("Server stopped");
        serverSocket.close();
        System.exit(0);
    }
}