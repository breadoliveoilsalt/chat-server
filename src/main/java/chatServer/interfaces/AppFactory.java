package chatServer.interfaces;

import chatServer.logic.ChatServerListeningLoop;
import chatServer.logic.EchoLoopClientWelcome;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface AppFactory {

    ServerSokket createServerSokketListeningAtPort(int port) throws IOException;

    Reader createReader(InputStream inputStream);

    Writer createWriter(OutputStream outputStream);

    Runnable createEchoLoopInit(Sokket connectedSokket, AppFactory factory);

    EchoLoopClientWelcome createWelcome(Writer writer, Reader reader);

    ClientProtocol createEchoLoop(Reader reader, Writer writer);

    Thread createThreadFor(Runnable runnable);

    ChatServerListeningLoop createChatServerListeningLoop(ServerSokket serverSokket, AppFactory factory);

}
