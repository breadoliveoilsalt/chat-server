package chatServer.logic;

import chatServer.interfaces.AppFactory;
import chatServer.interfaces.ServerSokket;

import java.io.IOException;

public class ChatServerInit {

    private final int port;
    private ChatServerListeningLoop serverListeningLoop;
    private final AppFactory factory;
    private ServerSokket serverSokket;

    public ChatServerInit(int port, AppFactory factory) {
        this.port = port;
        this.factory = factory;
    }

    public void start() throws IOException {

        try {
            instantiateServerSokket();
            instantiateServerListeningLoop();
            runServerListeningLoop();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeServerSokket();
        }

    }

    private void instantiateServerSokket() throws IOException {
        serverSokket = factory.createServerSokketListeningAtPort(port);
    }

    private void instantiateServerListeningLoop() {
        serverListeningLoop = factory.createChatServerListeningLoop(serverSokket, factory);
    }

    private void runServerListeningLoop() throws IOException {
        serverListeningLoop.run();
    }

    private void closeServerSokket() throws IOException {
        serverSokket.close();
    }

}
