package mocks;

import chatServer.interfaces.Sokket;

import java.io.InputStream;
import java.io.OutputStream;

public class MockSokket implements Sokket {

    private boolean gotInputStream = false;
    public boolean gotInputStream() {
        return gotInputStream;
    }

    private boolean gotOutputStream = false;
    public boolean gotOutputStream() {
        return gotOutputStream;
    }

    private boolean closed = false;
    public boolean isClosed() {
        return closed;
    }

//    public MockSokket(int port) {
//
//    }

    @Override
    public InputStream getInputStream() {
        gotInputStream = true;
        return new MockInputStream();
    }

    @Override
    public OutputStream getOutputStream() {
        gotOutputStream = true;
        return new MockOutputStream();
    }

    @Override
    public void close() {
        closed = true;
    }

}
