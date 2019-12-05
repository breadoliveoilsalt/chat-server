package mocks;

import chatServer.interfaces.AppFactory;
import chatServer.interfaces.Sokket;
import chatServer.logic.ClientInitRunnable;
import chatServer.models.ChatRoom;

public class MockClientInitRunnable extends ClientInitRunnable {


    private int callCountForRun = 0;
    public int getCallCountForRun() {
        return callCountForRun;
    }

    public MockClientInitRunnable(Sokket sokket, ChatRoom chatRoom, AppFactory factory) {
        super(sokket, chatRoom, factory);
    }

    public void run() {
        callCountForRun += 1;
    }

}
