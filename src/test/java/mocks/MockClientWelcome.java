package mocks;

import chatServer.interfaces.ClientProtocol;

public class MockClientWelcome implements ClientProtocol {

    private int callCountForRun = 0;
    public int getCallCountForRun() {
        return callCountForRun;
    }

    @Override
    public void run() {
        callCountForRun += 1;

    }
}
