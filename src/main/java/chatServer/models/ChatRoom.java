package chatServer.models;

import chatServer.interfaces.AppFactory;
import chatServer.models.Client;

import java.io.IOException;
import java.util.ArrayList;

public class ChatRoom {

    private final AppFactory factory;
    private Client moderator;
    protected ArrayList<Client> clients = new ArrayList<>();

    public ChatRoom(AppFactory factory) {
        this.factory = factory;
//        this.moderator = factory.createModerator();
    }

    public synchronized void broadcastToAllClients(Client sendingClient, String message) {
        for (Client client : clients) {
            if (client != sendingClient) {
                client.sendMessage(">> " + sendingClient.getClientName() + ": " + message);
            } else {
                client.sendMessage(">> You: " + message);
            }
        }
    }

    public synchronized void addClient(Client client) {
        clients.add(client);
        beginListeningThreadForClient(client);
//        String message = client.getClientName() + " has joined.";
//        broadcastToAllClients(moderator, message);
    }

    public synchronized void removeClient(Client client) throws IOException {
        clients.remove(client);
        client.leave();
//        String message = client.getClientName() + " has left.";
//        broadcastToAllClients(moderator, message);
    }

    private void beginListeningThreadForClient(Client client) {
        Runnable runnable = factory.createListenForClientMessageRunnable(client, this);
        Thread thread = factory.createThreadFor(runnable);
        thread.start();
    }

}
