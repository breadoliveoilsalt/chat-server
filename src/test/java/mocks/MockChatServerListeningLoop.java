package mocks;

import chatServer.interfaces.AppFactory;
import chatServer.interfaces.ServerSokket;
import chatServer.logic.ChatServerListeningLoop;

public class MockChatServerListeningLoop extends ChatServerListeningLoop {

    private int callCountForRun = 0;
    public int getCallCountForRun() {
        return callCountForRun;
    }

    public MockChatServerListeningLoop(ServerSokket serverSokket, AppFactory factory) {
        super(serverSokket, factory);
    }

    @Override
    public void run() {
        callCountForRun += 1;
    }
}
