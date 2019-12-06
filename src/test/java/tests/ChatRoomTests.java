package tests;

import chatServer.interfaces.AppFactory;
import chatServer.models.ChatRoom;
import mocks2.TestableChatRoom;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChatRoomTests {

    ChatRoom chatRoom;
    AppFactory factory;

    @Before
    public void initTests() {
        chatRoom = new TestableChatRoom();
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
        assertEquals(exptectedClients, chatRoom.getClients());
    }

    @Test
    public void testAddClientBeginsAThreadListeningForAClientMessage() {
        assertEquals(1, factory.callCountForCreateListenClientRunnable);
        assertEquals(1, factory.callCountForCreateThread);
        assertEquals(clientRunnable, thread.runnable);
        assertEquals(1, thread.callCountForStart);
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
        assertEquals(1, removedClient.callCountForLeave);
    }
}
