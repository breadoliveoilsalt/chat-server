package factoryForTests;

import chatServer.factory.AppFactory;
import chatServer.logic.ChatServerListeningLoop;
import chatServer.models.ChatRoom;
import chatServer.models.Client;
import chatServer.wrappers.Reader;
import chatServer.wrappers.ServerSokket;
import chatServer.wrappers.Sokket;
import chatServer.wrappers.Writer;
import testableObjects.TestableThread;

import java.io.InputStream;
import java.io.OutputStream;

public class MockAppFactory implements AppFactory {

    private ServerSokket serverSokket;
    public MockAppFactory setServerSokketToReturn(ServerSokket serverSokket) {
        this.serverSokket = serverSokket;
        return this;
    }
    public int callCountForCreateServerSokket = 0;

    private Reader reader;
    public MockAppFactory setReaderToReturn(Reader reader) {
        this.reader = reader;
        return this;
    }

    private Writer writer;
    public MockAppFactory setWriterToReturn(Writer writer) {
        this.writer = writer;
        return this;
    }

    private ChatServerListeningLoop chatServerListeningLoop;
    public MockAppFactory setChatServerListeningLoopToReturn(ChatServerListeningLoop chatServerListeningLoop) {
        this.chatServerListeningLoop = chatServerListeningLoop;
        return this;
    }
    public int callCountForCreateChatServerListeningLoop = 0;

    private ChatRoom chatRoom;
    public MockAppFactory setChatRoomToReturn(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
        return this;
    }
    public int callCountForCreateChatRoom = 0;

    private Runnable clientInitRunnable;
    public MockAppFactory setClientInitRunnableToReturn(Runnable clientInitRunnable) {
        this.clientInitRunnable = clientInitRunnable;
        return this;
    }
    public int callCountForCreateClientInitRunnable = 0;

    private Client client;
    public MockAppFactory setClientToReturn(Client client) {
        this.client = client;
        return this;
    }
    public int callCountForCreateClient = 0;

    private Runnable listenForClientMessageRunnableToReturn;
    public MockAppFactory setListenForClientMessageRunnableToReturn(Runnable listenForClientMessageRunnableToReturn) {
        this.listenForClientMessageRunnableToReturn = listenForClientMessageRunnableToReturn;
        return this;
    }

    public int callCountForCreateThreadFor = 0;

    private TestableThread testableThreadToReturn;
    public MockAppFactory setTestableThreadToReturn(TestableThread testableThreadToReturn) {
        this.testableThreadToReturn = testableThreadToReturn;
        return this;
    }

    @Override
    public ServerSokket createServerSokketListeningAtPort(int port) {
        callCountForCreateServerSokket += 1;
        return serverSokket;
    }

    @Override
    public Reader createReader(InputStream inputStream) {
        return reader;
    }

    @Override
    public Writer createWriter(OutputStream outputStream) {
        return writer;
    }

    @Override
    public Thread createThreadFor(Runnable runnable) {
        callCountForCreateThreadFor += 1;
        return testableThreadToReturn.establishWithRunnable(runnable);
    }

    @Override
    public ChatServerListeningLoop createChatServerListeningLoop(ServerSokket serverSokket, ChatRoom chatRoom, AppFactory factory) {
        callCountForCreateChatServerListeningLoop += 1;
        return chatServerListeningLoop;
    }

    @Override
    public ChatRoom createChatRoom(AppFactory factory) {
        callCountForCreateChatRoom += 1;
        return chatRoom;
    }

    @Override
    public Runnable createClientInitRunnable(Sokket sokket, ChatRoom chatRoom, AppFactory factory) {
        callCountForCreateClientInitRunnable += 1;
        return clientInitRunnable;
    }

    @Override
    public Client createClient(Sokket sokket, AppFactory factory) {
        callCountForCreateClient += 1;
        return client;
    }

    @Override
    public Runnable createListenForClientMessageRunnable(Client client, ChatRoom chatRoom) {
        return listenForClientMessageRunnableToReturn;
    }
}
