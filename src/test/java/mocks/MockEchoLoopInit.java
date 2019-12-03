package mocks;

import chatServer.interfaces.ClientProtocol;

public class MockEchoLoopInit implements Runnable, ClientProtocol {

    private int runCallCount = 0;
    public int getRunCallCount() {
        return runCallCount;
    }

    public void run() {
        runCallCount += 1;
    }

}
