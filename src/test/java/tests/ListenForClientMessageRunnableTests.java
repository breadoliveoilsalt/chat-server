package tests;

import chatServer.logic.EchoLoop;
import chatServer.logic.ListenForClientMessageRunnable;
import mocks.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListenForClientMessageRunnableTests {

//    private MockReader reader;
//    private MockWriter writer;
//    private EchoLoop echoLoop;
    private MockClient client;
    private MockChatRoom chatRoom;
    private MockAppFactory factory;
    private Runnable listenForClientMessageRunnable;
    private List<String> expectedSentMessages;

    @Before
    public void init() {
        factory = new MockAppFactory();
        client = new MockClient();
        chatRoom = new MockChatRoom(factory);
        listenForClientMessageRunnable = new ListenForClientMessageRunnable(client, chatRoom);
        expectedSentMessages = new ArrayList<>();
    }

    @Test
    public void testRunBeginsALoopThatReadsLineFromClientAndSendsSameMessageBackToClientWithName() throws IOException {
        client.messagesFromClient = new ArrayList<>(Arrays.asList("Hello!", "exit!"));
        expectedSentMessages.add("Hello!");

        listenForClientMessageRunnable.run();

        assertEquals(expectedSentMessages, chatRoom.messagesSentToAllClients);
    }

//     @Test public void testRunContinuesTheLoopUntilClientSendsExitMessage() throws IOException {
//        reader.setMockMessagesToReceiveFromClient(new ArrayList<>(Arrays.asList("Hello!", "How are you?", "Bye!", "exit!")));
//        expectedSentMessages.addAll(Arrays.asList("Joey: Hello!", "Joey: How are you?", "Joey: Bye!"));
//
//        echoLoop.run();
//
//        assertEquals(expectedSentMessages, writer.getMessagesSentToClient());
//     }
//
//     @Test public void testRunStopsAsSoonAsClientSendsExitMessage() throws IOException {
//         reader.setMockMessagesToReceiveFromClient(new ArrayList<>(Arrays.asList("exit!", "Hello!", "How are you?")));
//
//         echoLoop.run();
//
//         assertTrue((writer.getMessagesSentToClient()).isEmpty());
//     }
}
