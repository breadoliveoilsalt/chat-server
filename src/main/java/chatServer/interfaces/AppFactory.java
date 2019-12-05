package chatServer.interfaces;

import chatServer.logic.ChatServerListeningLoop;
import chatServer.logic.EchoLoopClientWelcome;
import chatServer.models.ChatRoom;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface AppFactory {

    ServerSokket createServerSokketListeningAtPort(int port) throws IOException;

    Reader createReader(InputStream inputStream);

    Writer createWriter(OutputStream outputStream);

    Runnable createEchoLoopInit(Sokket connectedSokket, AppFactory factory);

    EchoLoopClientWelcome createWelcome(Writer writer, Reader reader);

    ClientProtocol createEchoLoop(Reader reader, Writer writer, String name);

    Thread createThreadFor(Runnable runnable);

    ChatServerListeningLoop createChatServerListeningLoop(ServerSokket serverSokket, ChatRoom chatRoom, AppFactory factory);

    ChatRoom createChatRoom(AppFactory factory);

    Runnable createClientInitRunnable(Sokket sokket, ChatRoom chatRoom, AppFactory factory);
}
