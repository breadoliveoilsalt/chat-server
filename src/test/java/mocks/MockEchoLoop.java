package mocks;

import echoServer.interfaces.ClientProtocol;
import echoServer.interfaces.Reader;
import echoServer.interfaces.Writer;

public class MockEchoLoop implements ClientProtocol {

    private int callCountForRun = 0;
    public int getCallCountForRun() {
        return callCountForRun;
    }

    public MockEchoLoop(Reader reader, Writer writer) {
    }

    @Override
    public void run() {
       callCountForRun += 1;
    }

}
