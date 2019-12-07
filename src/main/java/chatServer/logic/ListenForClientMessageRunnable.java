package chatServer.logic;

import chatServer.models.ChatRoom;
import chatServer.models.Client;

import java.io.IOException;

public class ListenForClientMessageRunnable implements Runnable {

    private Client client;
    private ChatRoom chatRoom;
    private String messageFromClient;

    public ListenForClientMessageRunnable(Client client, ChatRoom chatRoom) {
        this.client = client;
        this.chatRoom = chatRoom;
    };

    public void run() {
        try {
            messageFromClient = client.getMessage();
            while (!messageFromClient.equals("exit!")) {
                chatRoom.broadcastToAllClients(client, messageFromClient);
                messageFromClient = client.getMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                chatRoom.removeClient(client);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}