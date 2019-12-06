package chatServer.models;

import chatServer.interfaces.AppFactory;
import chatServer.interfaces.Reader;
import chatServer.interfaces.Sokket;
import chatServer.interfaces.Writer;

import java.io.IOException;

public class Client {
    private Sokket sokket;
    private String clientName;
    public String getClientName() {
        return clientName;
    }

    private Writer writerToClient;
    private Reader readerFromClient;

    public Client() {};

    public Client(Sokket sokket, ChatRoom chatRoom, AppFactory factory) throws IOException {
        this.sokket = sokket;
        this.writerToClient = factory.createWriter(sokket.getOutputStream());
        this.readerFromClient = factory.createReader(sokket.getInputStream());
//        askForClientName();
    }
}
