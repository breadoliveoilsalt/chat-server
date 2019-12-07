package tests;

import chatServer.interfaces.AppFactory;
import chatServer.logic.ListenForClientMessageRunnable;
import chatServer.models.ChatRoom;
import chatServer.models.Client;
import mocks.MockAppFactory;
import mocks.MockClient;
import mocks.MockListenForClientMessageRunnable;
import mocks.MockThread;
import mocks2.TestableChatRoom;
import mocks2.TestableClient;
import mocks2.TestableThread;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ChatRoomTests {

    TestableChatRoom chatRoom;

    MockAppFactory factory;
    Thread thread;
    MockClient client1;
    MockClient client2;
    MockClient client3;
    MockClient newClient;
    MockListenForClientMessageRunnable listeningRunnable;
    TestableThread testableThread;


    @Before
    public void initTests() {
        newClient = new MockClient();
        listeningRunnable = new MockListenForClientMessageRunnable(newClient, chatRoom);
        testableThread = new TestableThread();

        factory = new MockAppFactory();
        factory.setListenForClientMessageRunnableToReturn(listeningRunnable).setTestableThreadToReturn(testableThread);
        chatRoom = new TestableChatRoom(factory);
        addBaseClientsToChatRoom();
    }

    private void addBaseClientsToChatRoom() {
        client1 = new MockClient();
        client2 = new MockClient();
        client3 = new MockClient();
        chatRoom.setClients(new ArrayList<Client>(Arrays.asList(client1, client2, client3)));
    }

    @Test
    public void testBroadcastToAllClientsSendsAMessageWithTheSendingClientNameToAllClientsExceptTheSendingClient() {
        // add clients
        // add clients
        // chatRoom.broadcastToAllClients(sendingClient, message);
        // expected message = sendingclient's name with message);
        // assertEquals
        // Testable client needs to have a messages received and then we get the last message received.
    }

    @Test
    public void testBroadcastToAllClientsSendsAMessageWithAYouPromptToTheSendingClient() {
        // see above
    }

    @Test
    public void testAddClientAddsAClientToTheListOfClientsInTheChatRoom() {

        chatRoom.addClient(newClient);

        ArrayList<Client> chatRoomClientList = chatRoom.getClients();

        Client lastClientAddedToChatRoomList = chatRoomClientList.get(chatRoomClientList.size() - 1);

        assertEquals(newClient, lastClientAddedToChatRoomList);
    }

    @Test
    public void testAddClientBeginsAThreadListeningForAClientMessage() {
        chatRoom.addClient(newClient);
        assertEquals(listeningRunnable, testableThread.getRunnablePassedToThread());
        assertEquals(1, testableThread.getCallCountForStart());
        assertEquals(1, listeningRunnable.getCallCountForRun());
    }

    @Test
    public void testRemoveClientRemovesAClientFromTheListOfClientsInTheChatRoom() throws IOException {
        chatRoom.addClient(newClient);
        ArrayList<Client> expectedClients = new ArrayList<Client>(Arrays.asList(client1, client2, client3));

        chatRoom.removeClient(newClient);

        assertEquals(expectedClients, chatRoom.getClients());
    }

    @Test
    public void testRemoveClientTellsTheClientToLeave() throws IOException {
        chatRoom.addClient(newClient);

        chatRoom.removeClient(newClient);

        assertEquals(1, newClient.callCountForLeave);
        // NOTE RELIES ON PUBLIC METHOD ABOVE!
    }
}
