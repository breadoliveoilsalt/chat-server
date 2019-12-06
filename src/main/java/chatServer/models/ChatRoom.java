package chatServer.models;

import chatServer.interfaces.AppFactory;

import java.util.ArrayList;

public class ChatRoom {

    private AppFactory factory;
//    private Client moderator;
//    private ArrayList<Client> clients = new ArrayList<Client>();

    public ChatRoom(AppFactory factory) {
        this.factory = factory;
//        this.moderator = factory.createModerator();
    }

    public synchronized void addClient(Client client) {
//        clients.add(client);
//        beginListeningThreadForClient(client);
//        String message = client.getClientName() + " has joined.";
//        broadcastToAllClients(moderator, message);
    }
}
