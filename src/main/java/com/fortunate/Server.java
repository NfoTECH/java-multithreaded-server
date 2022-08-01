package com.fortunate;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;  //What is ServerSocket?

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    // Running the server
    public void startServer() {
        try {
            while(!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();          //This is a blocking method. Program waits for a client to connect
                System.out.println("New connection detected");  // and returns a Socket object which communicates with the client
                ClientHandler clientHandler = new ClientHandler(socket);

                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeServerSocket() {       // This method was necessary to avoid nested try and catch
        try {
            if (serverSocket != null) {     // Catch Null pointer exceptions
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234); // the port number the server is connected to matching that of the client
        Server server = new Server(serverSocket);                // Pass the port number to the server
        server.startServer();
    }
}
