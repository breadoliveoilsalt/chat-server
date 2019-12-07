package mocks;

import chatServer.models.Client;

import java.util.ArrayList;

public class MockClient extends Client {

    public int callCountForLeave = 0;
    public ArrayList<String> sentMessages = new ArrayList<String>();

    @Override
    public void leave() {
        callCountForLeave += 1;
    }

    @Override
    public void sendMessage(String string) {
        sentMessages.add(string);
    }
}
