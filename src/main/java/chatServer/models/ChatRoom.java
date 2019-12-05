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
}
