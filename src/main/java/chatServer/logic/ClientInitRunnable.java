package chatServer.logic;

import chatServer.interfaces.AppFactory;
import chatServer.interfaces.Sokket;
import chatServer.models.ChatRoom;
import chatServer.models.Client;

import java.io.IOException;

public class ClientInitRunnable implements Runnable {

    private final Sokket sokket;
    private final ChatRoom chatRoom;
    private final AppFactory factory;
    private Client newClient;

    public ClientInitRunnable(Sokket sokket, ChatRoom chatRoom, AppFactory factory) {
        this.sokket = sokket;
        this.chatRoom = chatRoom;
        this.factory = factory;
    }
    public void run() {
        try {
            instantiateNewClient();
            addClientToChatRoom();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void instantiateNewClient() throws IOException {
        newClient = factory.createClient(sokket, chatRoom, factory);
    }

    private void addClientToChatRoom() {
        chatRoom.addClient(newClient);
    }
}
