package mocks;

import chatServer.interfaces.AppFactory;
import chatServer.models.ChatRoom;
import chatServer.models.Client;

import java.util.ArrayList;

public class MockChatRoom extends ChatRoom {

    private ArrayList<Client> clients = new ArrayList<Client>();
    private int callCountForAddClient = 0;

    public MockChatRoom(AppFactory factory) {
        super(factory);
    }

    @Override
    public void addClient(Client client) {
        callCountForAddClient += 1;
        clients.add(client);
    }

    public Client getLastClientAdded() {
        return clients.get(clients.size() - 1);
    }

}
