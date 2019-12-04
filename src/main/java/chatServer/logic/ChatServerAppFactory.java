package chatServer.logic;

import chatServer.interfaces.*;
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

    public ClientProtocol createWelcome(Writer writer) {
       return new EchoLoopClientWelcome(writer);
    }

    public ClientProtocol createEchoLoop(Reader reader, Writer writer) {
        return new EchoLoop(reader, writer);
    }

    public Thread createThreadFor(Runnable runnable) {
        return new Thread(runnable);
    }

    public ChatServerListeningLoop createChatServerListeningLoop(ServerSokket serverSokket, AppFactory factory) { return new ChatServerListeningLoop(serverSokket, factory);
    }
}