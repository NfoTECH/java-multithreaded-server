package com.fortunate;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();  //To hold the list of clients
    private Socket socket;
    private BufferedReader bufferedReader;      // To read data(messages)
    private BufferedWriter bufferedWriter;      // To send data(messages)
    private String clientUsername;

    public ClientHandler(Socket socket) throws IOException {
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch ()
    }

    @Override
    public void run() {

    }
}
