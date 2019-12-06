package tests;

import chatServer.logic.ClientInitRunnable;
import mocks.MockAppFactory;
import mocks2.MockAppFactory2;
import mocks.MockSokket;
import mocks2.MockChatRoom2;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClientInitRunnableTest {

    private MockSokket sokket;
    private MockChatRoom2 chatRoom;
    private MockAppFactory factory;
    private ClientInitRunnable clientInitRunnable;

    @Before
    public void initTests() {
        sokket = new MockSokket();
        factory = new MockAppFactory();
        chatRoom = new MockChatRoom2(factory);
        clientInitRunnable = new ClientInitRunnable(sokket, chatRoom, factory);


    }

    @Test
    public void testRunInstantiatesANewClientFromTheAppFactory() {
        assertEquals(0, factory.callCountForCreateClient);

        clientInitRunnable.run();

        assertEquals(1, factory.callCountForCreateClient);
    }

//    @Test
//    public void testRunAddsTheClientToTheChatRoom() {
//        assertEquals(0, chatRoom.getCallCountForAddClient());
//
//        clientInitRunnable.run();
//
//        assertEquals(1, chatRoom.getCallCountForAddClient());
//    }

}
