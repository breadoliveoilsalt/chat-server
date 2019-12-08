package chatServer.models;

import chatServer.interfaces.AppFactory;
import chatServer.interfaces.Reader;
import chatServer.interfaces.Sokket;
import chatServer.interfaces.Writer;

import java.io.IOException;

public class Client {

    private Sokket sokket;
    protected String clientName;
    protected String getClientName() {
        return clientName;
    }

    protected Writer writerToClient;
    protected Reader readerFromClient;

    protected Client () {}

    public Client(Sokket sokket, ChatRoom chatRoom, AppFactory factory) throws IOException {
        this.sokket = sokket;
        this.writerToClient = factory.createWriter(sokket.getOutputStream());
        this.readerFromClient = factory.createReader(sokket.getInputStream());
        askForClientName();
    }

    public void sendMessage(String message) {
        writerToClient.printLine(message);
    }

    public String getMessage() throws IOException {
        return readerFromClient.readLine();
    }

    private void askForClientName() throws IOException {
        writerToClient.printLine(">> What is your name?");
        clientName = readerFromClient.readLine();
        writerToClient.printLine(">> Welcome to the Chat Room, " + clientName + "!");
    }

    public void leave() throws IOException {
        sokket.close();
    }

}
