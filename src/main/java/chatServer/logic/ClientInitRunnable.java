package chatServer.logic;

import chatServer.interfaces.AppFactory;
import chatServer.interfaces.Sokket;
import chatServer.models.ChatRoom;

public class ClientInitRunnable implements Runnable {

    private final Sokket sokket;
    private final ChatRoom chatRoom;
    private final AppFactory factory;

    public ClientInitRunnable(Sokket sokket, ChatRoom chatRoom, AppFactory factory) {
        this.sokket = sokket;
        this.chatRoom = chatRoom;
        this.factory = factory;
    }

    public void run() {

    }
}
