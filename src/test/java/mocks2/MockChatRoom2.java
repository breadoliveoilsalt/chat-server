package mocks2;

import chatServer.interfaces.AppFactory;
import chatServer.models.ChatRoom;
import chatServer.models.Client;

import java.util.ArrayList;

public class MockChatRoom2 extends ChatRoom {

    private ArrayList<Client> clients;

    public MockChatRoom2(AppFactory factory) {
        super(factory);
    }

    public ArrayList<Client> getClients() {
        return clients;
    }
}
