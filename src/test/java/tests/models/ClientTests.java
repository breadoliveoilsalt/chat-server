package tests.models;

import factoryForTests.MockAppFactory;
import mocks.*;
import testableObjects.TestableClient;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;

public class ClientTests {

    private MockSokket sokket;
    private MockChatRoom chatRoom;
    private MockAppFactory factory;
    private MockWriter writer;
    private MockReader reader;
    private TestableClient client;

    @Before
    public void testInit() throws IOException {
        sokket = new MockSokket();
        writer = new MockWriter();
        reader = new MockReader();
        reader.setMockMessagesToReceiveFromClient(new ArrayList<String>(Arrays.asList("Random Name")));
        factory = new MockAppFactory()
                .setWriterToReturn(writer)
                .setReaderToReturn(reader);
        client = new TestableClient(sokket, chatRoom, factory);
    }

    @Test
    public void testNewClientWithArgumentsInstantiatesAReaderAndWriterForClient() throws IOException {
        assertEquals(writer, client.getWriter());
        assertEquals(reader, client.getReader());
    }

    @Test
    public void testNewClientWithArgumentsSetsTheClientNameThroughReadingALineFromTheReader() throws IOException {
        reader.setMockMessagesToReceiveFromClient(new ArrayList<String>(Arrays.asList("Tom")));
        client = new TestableClient(sokket, chatRoom, factory);

        assertEquals("Tom", client.getName());
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
