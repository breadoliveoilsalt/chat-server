package mocks2;

import chatServer.interfaces.AppFactory;
import chatServer.interfaces.Sokket;
import chatServer.models.ChatRoom;
import chatServer.models.Client;

import java.io.IOException;

public class TestableClient extends Client {

    public TestableClient(Sokket sokket, ChatRoom chatRoom, AppFactory factory) throws IOException {
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

//    public void leave() throws IOException {
//        sokket.close();
//    }
    public String getName() {
        return clientName;
    }
}
