package tests;

import chatServer.logic.ChatServerInit;
import mocks.MockAppFactory;
import mocks.MockChatServerListeningLoop;
import mocks.MockServerSokket;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class ChatServerInitTests {

    private MockChatServerListeningLoop serverListeningLoop;
    private MockServerSokket serverSokket;
    private MockAppFactory factory;
    private ChatServerInit chatServer;

    @Before
    public void testInit() {
        serverSokket = new MockServerSokket();
        serverListeningLoop = new MockChatServerListeningLoop(serverSokket, factory);
        factory = new MockAppFactory()
            .setServerSokketToReturn(serverSokket)
            .setChatServerListeningLoopToReturn(serverListeningLoop);
        int samplePort = 8000;
        chatServer = new ChatServerInit(samplePort, factory);
    }

    @Test
    public void testStartInstantiatesAListeningServerSokket() throws IOException {
        assertEquals(0, factory.getCallCountForCreateServerSokket());

        chatServer.start();

        assertEquals(1, factory.getCallCountForCreateServerSokket());
    }

    @Test
    public void testStartInstantiatesAChatServerListentingLoop() throws IOException {
        assertEquals(0, factory.getCallCountForCreateChatServerListeningLoop());

        chatServer.start();

        assertEquals(1, factory.getCallCountForCreateChatServerListeningLoop());

    }
    @Test
    public void testStartRunsTheChatServerListeningLoop() throws IOException {
        assertEquals(0, serverListeningLoop.getCallCountForRun());

        chatServer.start();

        assertEquals(1, serverListeningLoop.getCallCountForRun());
    }

    @Test
    public void testStartClosesTheServerSokketAfterTheServerListeningLoopHasBeenRun() throws IOException {
        chatServer.start();

        assertEquals(1, serverListeningLoop.getCallCountForRun());
        assertTrue(serverSokket.isClosed());
    }

}
