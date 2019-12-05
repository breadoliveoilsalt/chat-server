package mocks;

import chatServer.interfaces.*;
import chatServer.logic.ChatServerListeningLoop;
import chatServer.logic.EchoLoopClientWelcome;

import java.io.InputStream;
import java.io.OutputStream;

public class MockAppFactory implements AppFactory {

    private ServerSokket serverSokket;
    public MockAppFactory setServerSokketToReturn(ServerSokket serverSokket) {
        this.serverSokket = serverSokket;
        return this;
    }
    private int callCountForCreateServerSokket = 0;
    public int getCallCountForCreateServerSokket() {
        return callCountForCreateServerSokket;
    }

    private Runnable echoLoopInit;
    public MockAppFactory setEchoLoopInitToReturn(Runnable echoLoopInit) {
        this.echoLoopInit = echoLoopInit;
        return this;
    }
    private int callCountForCreateEchoLoopInit = 0;
    public int getCallCountForCreateEchoLoopInit() {
        return callCountForCreateEchoLoopInit;
    }

    private Thread thread;
    public MockAppFactory setThreadToReturn(Thread thread) {
        this.thread = thread;
        return this;
    }
    private int callCountForCreateThreadFor = 0;
    public int getCallCountForCreateThreadFor() {
        return callCountForCreateThreadFor;
    }

    private Reader reader;
    public MockAppFactory setReaderToReturn(Reader reader) {
        this.reader = reader;
        return this;
    }
    private int callCountForCreateReader = 0;
    public int getCallCountForCreateReader() {
        return callCountForCreateReader;
    }

    private Writer writer;
    public MockAppFactory setWriterToReturn(Writer writer) {
        this.writer = writer;
        return this;
    }
    private int callCountForCreateWriter = 0;
    public int getCallCountForCreateWriter() {
        return callCountForCreateWriter;
    }

    private EchoLoopClientWelcome welcomer;
    public MockAppFactory setWelcomerToReturn(EchoLoopClientWelcome welcomer) {
        this.welcomer = welcomer;
        return this;
    }
    private int callCountForCreateWelcome = 0;
    public int getCallCountForCreateWelcome() {
        return callCountForCreateWelcome;
    }

    private ClientProtocol echoLoop;
    public MockAppFactory setEchoLoopToReturn(ClientProtocol echoLoop) {
        this.echoLoop = echoLoop;
        return this;
    }
    private int callCountForCreateEchoLoop = 0;
    public int getCallCountForCreateEchoLoop() {
        return callCountForCreateEchoLoop;
    }

    private ChatServerListeningLoop chatServerListeningLoop;
    public MockAppFactory setChatServerListeningLoopToReturn(ChatServerListeningLoop chatServerListeningLoop) {
        this.chatServerListeningLoop = chatServerListeningLoop;
        return this;
    }
    private int callCountForCreateChatServerListeningLoop = 0;
    public int getCallCountForCreateChatServerListeningLoop() {
        return callCountForCreateChatServerListeningLoop;
    }


    @Override
    public ServerSokket createServerSokketListeningAtPort(int port) {
        callCountForCreateServerSokket += 1;
        return serverSokket;
    }

    @Override
    public Reader createReader(InputStream inputStream) {
        callCountForCreateReader += 1;
        return reader;
    }

    @Override
    public Writer createWriter(OutputStream outputStream) {
        callCountForCreateWriter += 1;
        return writer;
    }

    @Override
    public Runnable createEchoLoopInit(Sokket connectedSokket, AppFactory factory) {
        callCountForCreateEchoLoopInit += 1;
        return echoLoopInit;
    }

    @Override
    public EchoLoopClientWelcome createWelcome(Writer writer, Reader reader) {
        callCountForCreateWelcome += 1;
        return welcomer;
    }

    @Override
    public ClientProtocol createEchoLoop(Reader reader, Writer writer) {
        callCountForCreateEchoLoop += 1;
        return echoLoop;
    }

    @Override
    public Thread createThreadFor(Runnable runnable) {
        callCountForCreateThreadFor += 1;
        return thread;
    }

    @Override
    public ChatServerListeningLoop createChatServerListeningLoop(ServerSokket serverSokket, AppFactory factory) {
        callCountForCreateChatServerListeningLoop += 1;
        return chatServerListeningLoop;
    }
}
