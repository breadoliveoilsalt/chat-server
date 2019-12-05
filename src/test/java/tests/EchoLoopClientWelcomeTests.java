package tests;

import chatServer.logic.EchoLoopClientWelcome;
import mocks.MockReader;
import mocks.MockWriter;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class EchoLoopClientWelcomeTests {

    @Test
    public void testGetClientNameReturnsTheResultFromReadingALineFromTheReader() throws IOException {
        MockWriter writer = new MockWriter();
        MockReader reader = new MockReader();
        reader.setMockMessagesToReceiveFromClient(new ArrayList<>(Arrays.asList("Joey")));

        String expectedReturnValue = "Joey";

        EchoLoopClientWelcome welcomer = new EchoLoopClientWelcome(writer, reader);

        assertEquals(expectedReturnValue, welcomer.getClientName());
    }
}
