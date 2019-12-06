package mocks2;

import chatServer.factory.ChatServerAppFactory;
import chatServer.interfaces.AppFactory;
import chatServer.interfaces.Sokket;
import chatServer.models.ChatRoom;
import chatServer.models.Client;

import java.io.IOException;

public class MockAppFactory2 extends ChatServerAppFactory {

    public int callCountForCreateClient = 0;

    @Override
    public Client createClient(Sokket sokket, ChatRoom chatRoom, AppFactory factory) throws IOException {
        callCountForCreateClient += 1;
        return super.createClient(sokket, chatRoom, factory);
    }
}
