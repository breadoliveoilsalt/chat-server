package tests;

import chatServer.interfaces.AppFactory;
import chatServer.models.ChatRoom;
import chatServer.models.Client;
import mocks.MockAppFactory;
import mocks2.TestableChatRoom;
import mocks2.TestableClient;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ChatRoomTests {

    TestableChatRoom chatRoom;
    AppFactory factory;
    TestableClient client1;
    TestableClient client2;
    TestableClient client3;


    @Before
    public void initTests() {
        factory = new MockAppFactory();
        chatRoom = new TestableChatRoom(factory);
        addBaseClientsToChatRoom();
    }

    private void addBaseClientsToChatRoom() {
        client1 = new TestableClient();
        client2 = new TestableClient();
        client3 = new TestableClient();
        chatRoom.setClients(new ArrayList<Client>(Arrays.asList(client1, client2, client3)));
    }

    @Test
    public void testBroadcastToAllClientsSendsAMessageWithTheSendingClientNameToAllClientsExceptTheSendingClient() {
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
        Client newClient = new TestableClient();

        chatRoom.addClient(newClient);

        ArrayList<Client> chatRoomClientList = chatRoom.getClients();

        Client lastClientAddedToChatRoomList = chatRoomClientList.get(chatRoomClientList.size() - 1);

        assertEquals(newClient, lastClientAddedToChatRoomList);
    }

    @Test
    public void testAddClientBeginsAThreadListeningForAClientMessage() {
//        assertEquals(1, factory.callCountForCreateListenClientRunnable);
//        assertEquals(1, factory.callCountForCreateThread);
//        assertEquals(clientRunnable, thread.runnable);
//        assertEquals(1, thread.callCountForStart);
    }

    @Test
    public void testRemoveClientRemovesAClientFromTheListOfClientsInTheChatRoom() {
        // add clients
        // set expected clients
        // call remove on client
        // assert on list of expected clients.
    }

    @Test
    public void testRemoveClientTellsTheClientToLeave() {
        // add clients
        // call remove on client
//        assertEquals(1, removedClient.callCountForLeave);
    }
}
