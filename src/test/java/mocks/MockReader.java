package mocks;

import echoServer.interfaces.Reader;

import java.util.ArrayList;
import java.util.List;

public class MockReader implements Reader {

    private List<String> mockMessagesFromClient;
    public void setMockMessagesToReceiveFromClient(ArrayList<String> mockMessagesToReceiveFromClient) {
        this.mockMessagesFromClient = mockMessagesToReceiveFromClient;
    }

    private boolean closed = false;
    public boolean isClosed() {
        return closed;
    }

    @Override
    public String readLine() {
        return mockMessagesFromClient.remove(0);
    }

    @Override
    public void close() {
        closed = true;
    }

}
