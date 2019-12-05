package mocks;

import chatServer.interfaces.AppFactory;
import chatServer.models.ChatRoom;

public class MockChatRoom extends ChatRoom {

    public MockChatRoom(AppFactory factory) {
        super(factory);
    }

}
