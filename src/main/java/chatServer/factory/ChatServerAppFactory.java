package chatServer.factory;

import chatServer.interfaces.*;
import chatServer.logic.ChatServerListeningLoop;
import chatServer.logic.EchoLoop;
import chatServer.logic.EchoLoopClientWelcome;
import chatServer.logic.EchoLoopInit;
import chatServer.models.ChatRoom;
import chatServer.wrappers.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChatServerAppFactory implements AppFactory {

    public JavaServerSocketWrapper createServerSokketListeningAtPort(int port) throws IOException {
        return new JavaServerSocketWrapper(port);
    }

    public JavaBufferedReaderWrapper createReader(InputStream inputStream) {
        return new JavaBufferedReaderWrapper(inputStream);
    }

    public JavaPrintWriterWrapper createWriter(OutputStream outputStream) {
        return new JavaPrintWriterWrapper(outputStream);
    }

    public Runnable createEchoLoopInit(Sokket connectedSokket, chatServer.interfaces.AppFactory factory) {
        return new EchoLoopInit(connectedSokket, factory);
    }

    public EchoLoopClientWelcome createWelcome(Writer writer, Reader reader) {
       return new EchoLoopClientWelcome(writer, reader);
    }

    public ClientProtocol createEchoLoop(Reader reader, Writer writer, String name) {
        return new EchoLoop(reader, writer, name);
    }

    public Thread createThreadFor(Runnable runnable) {
        return new Thread(runnable);
    }

    public ChatServerListeningLoop createChatServerListeningLoop(ServerSokket serverSokket, AppFactory factory) { return new ChatServerListeningLoop(serverSokket, factory);
    }

    public ChatRoom createChatRoom(AppFactory factory) {
        return new ChatRoom(factory);
    }
}
