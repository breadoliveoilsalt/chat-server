package tests;

import chatServer.interfaces.Sokket;
import chatServer.logic.ChatServerListeningLoop;
import mocks.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ChatServerListeningLoopTests {

    private MockServerSokket serverSokket;
    private MockAppFactory factory;
    private MockSokket sokket;
    private MockChatRoom chatRoom;
    private MockClientInitRunnable clientInitRunnable;
    private MockThread thread;
    private ChatServerListeningLoop chatServerListeningLoop;

    @Before
    public void testInit() {
        initServerSokket();
        initFactory();
        initChatServerListeningLoop();
        setLoopToRunOnce();
    }

    private void initServerSokket() {
        int samplePort = 8000;
        sokket = new MockSokket(samplePort);
        serverSokket = new MockServerSokket();
        serverSokket.setMockSokketToReturnFollowingConnection(sokket);
    }

    private void initFactory() {
        chatRoom = new MockChatRoom(factory);
        clientInitRunnable = new MockClientInitRunnable(sokket, chatRoom, factory);
        thread = new MockThread(clientInitRunnable);
        factory = new MockAppFactory()
            .setThreadToReturn(thread)
            .setClientInitRunnableToReturn(clientInitRunnable);
    }

    private void initChatServerListeningLoop() {
        chatServerListeningLoop = new ChatServerListeningLoop(serverSokket, chatRoom, factory);
    }

    private void setLoopToRunOnce() {
        ArrayList<Boolean> loopConditionWhetherServerSokketIsBound = new ArrayList<>(Arrays.asList(true, false));
        serverSokket.setIsBoundToPort(loopConditionWhetherServerSokketIsBound);
    }

    @Test
    public void testRunLoopGetsASokketConnectedToClient() throws IOException {
        setLoopToRunOnce();

        chatServerListeningLoop.run();

        assertEquals(1, serverSokket.getCallCountForAcceptConnectionAndReturnConnectedSokket());
    }

    @ Test
    public void testRunLoopInstantiatesAClientInitThread() throws IOException {
        setLoopToRunOnce();

        chatServerListeningLoop.run();

        assertEquals(1, factory.getCallCountForCreateClientInitRunnable());
        assertEquals(1, factory.getCallCountForCreateThreadFor());
    }

    @Test
    public void testRunLoopStartsTheThread() throws IOException {
        setLoopToRunOnce();

        chatServerListeningLoop.run();

        assertEquals(1, clientInitRunnable.getCallCountForRun());
        assertEquals(1, thread.getCallCountForStart());
    }

    @Test
    public void testRunLoopRepeatsSoLongAsServerSokketIsBound() throws IOException {
        setLoopToRunThreeTimes();

        chatServerListeningLoop.run();

        assertEquals(3, serverSokket.getCallCountForAcceptConnectionAndReturnConnectedSokket());
        assertEquals(3, factory.getCallCountForCreateClientInitRunnable());
        assertEquals(3, factory.getCallCountForCreateThreadFor());
        assertEquals(3, clientInitRunnable.getCallCountForRun());
        assertEquals(3, thread.getCallCountForStart());

    }

    private void setLoopToRunThreeTimes() {
        ArrayList<Boolean> loopConditionWhetherServerSokketIsBound = new ArrayList<>(Arrays.asList(true, true, true, false));
        serverSokket.setIsBoundToPort(loopConditionWhetherServerSokketIsBound);
    }
}
