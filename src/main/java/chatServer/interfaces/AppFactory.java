package chatServer.interfaces;

import chatServer.logic.ChatServerListeningLoop;
import chatServer.models.ChatRoom;
import chatServer.models.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface AppFactory {

    ServerSokket createServerSokketListeningAtPort(int port) throws IOException;

    Reader createReader(InputStream inputStream);

    Writer createWriter(OutputStream outputStream);

    Thread createThreadFor(Runnable runnable);

    ChatServerListeningLoop createChatServerListeningLoop(ServerSokket serverSokket, ChatRoom chatRoom, AppFactory factory);

    ChatRoom createChatRoom(AppFactory factory);

    Runnable createClientInitRunnable(Sokket sokket, ChatRoom chatRoom, AppFactory factory);

    Client createClient(Sokket sokket, ChatRoom chatRoom, AppFactory factory) throws IOException;

    Runnable createListenForClientMessageRunnable(Client client, ChatRoom chatRoom);
}
