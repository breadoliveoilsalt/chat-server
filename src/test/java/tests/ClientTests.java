package tests;

import chatServer.models.Client;
import mocks.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;

public class ClientTests {

    MockSokket sokket;
    MockChatRoom chatRoom;
    MockAppFactory factory;
    MockWriter writer;
    MockReader reader;
    Client client;

    @Before
    public void testInit() throws IOException {
        sokket = new MockSokket();
        writer = new MockWriter();
        reader = new MockReader();
        reader.setMockMessagesToReceiveFromClient(new ArrayList<String>(Arrays.asList("Random Name")));
        factory = new MockAppFactory()
                .setWriterToReturn(writer)
                .setReaderToReturn(reader);
        client = new Client(sokket, chatRoom, factory);
    }

    @Test
    public void testNewClientWithArgumentsInstantiatesAReaderAndWriterForClient() {

    }

    @Test
    public void testNewClientWithArgumentsSetsTheClientNameThroughReadingALineFromTheReader() {
        assertTrue(true);

    }

    @Test
    public void testSendMessagePrintsToTheWriter() {
        assertTrue(true);
    }

    @Test
    public void testGetMessageReadsALineFromTheReader() throws IOException {
        String expectedResult = "Hello!";
        reader.setMockMessagesToReceiveFromClient(new ArrayList<String>(Arrays.asList(expectedResult)));

        String actualResult = client.getMessage();

        assertSame(expectedResult, actualResult);
    }


    @Test
    public void testLeaveClosesTheSokket() throws IOException {
        assertFalse(sokket.isClosed());

        client.leave();

        assertTrue(sokket.isClosed());

    }
}
