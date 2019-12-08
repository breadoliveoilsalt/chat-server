package chatServer.factory;

import chatServer.interfaces.*;
import chatServer.logic.*;
import chatServer.models.ChatRoom;
import chatServer.models.Client;
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

    public Thread createThreadFor(Runnable runnable) {
        return new Thread(runnable);
    }

    public ChatServerListeningLoop createChatServerListeningLoop(ServerSokket serverSokket, ChatRoom chatRoom, AppFactory factory) { return new ChatServerListeningLoop(serverSokket, chatRoom, factory);
    }

    public ChatRoom createChatRoom(AppFactory factory) {
        return new ChatRoom(factory);
    }

    public Runnable createClientInitRunnable(Sokket sokket, ChatRoom chatRoom, AppFactory factory) {
        return new ClientInitRunnable(sokket, chatRoom, factory);
    }

    public Client createClient(Sokket sokket, ChatRoom chatRoom, AppFactory factory) throws IOException {
        return new Client(sokket, chatRoom, factory);
    }

    public Runnable createListenForClientMessageRunnable(Client client, ChatRoom chatRoom) {
        return new ListenForClientMessageRunnable(client, chatRoom);
    }


}
