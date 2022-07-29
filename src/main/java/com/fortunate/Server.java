package com.fortunate;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private ServerSocket serverSocket;  //What is ServerSocket?

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    // Starting the server
    public void startServer() {
        try {
            while(!serverSocket.isClosed()) {
                serverSocket.accept();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
