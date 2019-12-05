package tests;

import chatServer.logic.EchoLoop;
import mocks.MockReader;
import mocks.MockWriter;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EchoLoopTests {

    private MockReader reader;
    private MockWriter writer;
    private EchoLoop echoLoop;
    private List<String> expectedSentMessages;

    @Before
    public void init() {
        reader = new MockReader();
        writer = new MockWriter();
        String clientName = "Joey";
        echoLoop = new EchoLoop(reader, writer, clientName);
        expectedSentMessages = new ArrayList<>();
    }

    @Test
    public void testRunBeginsALoopThatReadsLineFromClientAndSendsSameMessageBackToClientWithName() throws IOException {
        reader.setMockMessagesToReceiveFromClient(new ArrayList<>(Arrays.asList("Hello!", "exit!")));
        expectedSentMessages.add("Joey: Hello!");

        assertTrue(writer.getMessagesSentToClient().isEmpty());
        echoLoop.run();

        assertEquals(expectedSentMessages, writer.getMessagesSentToClient());
    }

     @Test public void testRunContinuesTheLoopUntilClientSendsExitMessage() throws IOException {
        reader.setMockMessagesToReceiveFromClient(new ArrayList<>(Arrays.asList("Hello!", "How are you?", "Bye!", "exit!")));
        expectedSentMessages.addAll(Arrays.asList("Joey: Hello!", "Joey: How are you?", "Joey: Bye!"));

        echoLoop.run();

        assertEquals(expectedSentMessages, writer.getMessagesSentToClient());
     }

     @Test public void testRunStopsAsSoonAsClientSendsExitMessage() throws IOException {
         reader.setMockMessagesToReceiveFromClient(new ArrayList<>(Arrays.asList("exit!", "Hello!", "How are you?")));

         echoLoop.run();

         assertTrue((writer.getMessagesSentToClient()).isEmpty());
     }
}
