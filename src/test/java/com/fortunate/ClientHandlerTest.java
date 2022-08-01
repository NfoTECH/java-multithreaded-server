package com.fortunate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ClientHandlerTest {

    @Test
    @DisplayName("Should remove the clientHandler from the list of clientHandlers")
    void closeEverythingShouldRemoveClientHandlerFromListOfClientHandlers() throws IOException {
        ClientHandler clientHandler = new ClientHandler(new Socket());
        clientHandler.closeEverything(new Socket(), null, null);
        assertFalse(ClientHandler.clientHandlers.contains(clientHandler));
    }

    @Test
    @DisplayName("Should broadcast a message that the client has left the chat")
    void closeEverythingShouldBroadcastMessageThatClientHasLeftTheChat() throws IOException {
        Socket socket = new Socket();
        ClientHandler clientHandler = new ClientHandler(socket);
        clientHandler.closeEverything(socket, null, null);
        assertEquals(0, clientHandler.clientHandlers.size());
    }

    @Test
    @DisplayName("Should remove the client from the list of clients")
    void removeClientHandlerShouldRemoveTheClientFromTheListOfClients() throws IOException {
        ClientHandler clientHandler = new ClientHandler(new Socket());
        clientHandler.removeClientHandler();
        assertEquals(0, ClientHandler.clientHandlers.size());
    }

    @Test
    @DisplayName("Should send the message to all clients except the sender")
    void broadcastMessageShouldSendTheMessageToAllClientsExceptTheSender() throws IOException {
        ClientHandler clientHandler = new ClientHandler(new Socket());
        clientHandler.broadcastMessage("test");
        assertEquals(0, ClientHandler.clientHandlers.size());
    }

    @Test
    @DisplayName("Should not send the message to the sender")
    void broadcastMessageShouldNotSendTheMessageToTheSender() throws IOException {
        Socket socket = new Socket();
        ClientHandler clientHandler = new ClientHandler(socket);
        clientHandler.broadcastMessage("test");
        assertEquals(0, ClientHandler.clientHandlers.size());
    }

    @Test
    @DisplayName("Should broadcast the message to all clients except the sender")
    void runShouldBroadcastMessageToAllClientsExceptTheSender() throws IOException {
        ClientHandler clientHandler = new ClientHandler(new Socket());
        clientHandler.run();
        assertEquals(ClientHandler.clientHandlers.size(), 0);
    }

    @Test
    @DisplayName("Should remove the client handler when the socket is not connected")
    void runShouldRemoveClientHandlerWhenSocketIsNotConnected() throws IOException {
        ClientHandler clientHandler = new ClientHandler(new Socket());
        clientHandler.socket.isConnected();
        clientHandler.run();
        assertEquals(0, ClientHandler.clientHandlers.size());
    }
}