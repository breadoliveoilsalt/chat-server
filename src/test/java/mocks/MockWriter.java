package mocks;

import echoServer.interfaces.Writer;

import java.util.ArrayList;
import java.util.List;

public class MockWriter implements Writer {

    private final List<String> messagesSentToClient = new ArrayList<>();
    public List getMessagesSentToClient() {
        return messagesSentToClient;
    }

    private boolean closed = false;
    public boolean isClosed() {
        return closed;
    }

    @Override
    public void printLine(String message) {
        messagesSentToClient.add(message);
    }

    @Override
    public void close() {
        closed = true;
    }

}
