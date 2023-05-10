package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public GameClient(String serverAddress, int serverPort) throws IOException {
        socket = new Socket(serverAddress, serverPort);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);
    }

    public void start() throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine;
        while ((inputLine = inputReader.readLine()) != null) {
            output.println(inputLine);
            if (inputLine.equals("exit")) {
                break;
            }
            System.out.println(input.readLine());
        }
        socket.close();
    }
}
