package tests;

import chatServer.logic.ClientInitRunnable;
import chatServer.models.Client;
import mocks.MockAppFactory;
import mocks.MockClient;
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
    private Client newClient;
    private ClientInitRunnable clientInitRunnable;

    @Before
    public void initTests() {
        sokket = new MockSokket();
        newClient = new MockClient();
        factory = new MockAppFactory().setClientToReturn(newClient);
        chatRoom = new MockChatRoom2(factory);
        clientInitRunnable = new ClientInitRunnable(sokket, chatRoom, factory);

    }

    @Test
    public void testRunInstantiatesANewClientFromTheAppFactory() {
        assertEquals(0, factory.callCountForCreateClient);

        clientInitRunnable.run();

        assertEquals(1, factory.callCountForCreateClient);
    }

    @Test
    public void testRunAddsTheClientToTheChatRoom() {
        clientInitRunnable.run();
        assertEquals(newClient, chatRoom.getClients().get(0));
    }

}
