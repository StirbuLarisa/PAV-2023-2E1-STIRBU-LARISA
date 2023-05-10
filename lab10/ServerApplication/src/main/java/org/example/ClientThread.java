package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    private GameServer server;

    public ClientThread(Socket socket, GameServer server) throws IOException {
        this.socket = socket;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));  // transform bytes into characters to be passed to buffered reader
        this.output = new PrintWriter(socket.getOutputStream(), true);
        this.server = server;
    }

    public void run() {
        try {
            String inputLine;
            while ((inputLine = input.readLine()) != null) {
                if (inputLine.equals("stop")) {
                    output.println("Server stopped");
                    server.stop();
                    break;
                } else if (inputLine.equals("exit")) {
                    output.println("You have been disconnected");
                    socket.close();
                    break;
                } else {
                    output.println("Server received the request: " + inputLine);
                    System.out.println("I received the request: " + inputLine);
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}