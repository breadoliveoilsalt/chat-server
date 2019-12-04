package chatServer.logic;

import chatServer.interfaces.*;

import java.io.IOException;

public class ChatServerListeningLoop {

    private ServerSokket serverSokket;
    private AppFactory factory;
    private Sokket connectedSokket;
    private Thread threadToStart;

    public ChatServerListeningLoop(ServerSokket serverSokket, AppFactory factory) {
        this.serverSokket = serverSokket;
        this.factory = factory;
    }

    public void run() throws IOException {
        while (serverSokket.isBoundToAPort()) {
            getSokketConnectedToClient();
            initializeThreadedEchoLoop();
            startThread();
        }
    }

    private void getSokketConnectedToClient() throws IOException {
        connectedSokket = serverSokket.acceptConnectionAndReturnConnectedSokket();
    }

    private void initializeThreadedEchoLoop() {
        Runnable echoLoopInit = factory.createEchoLoopInit(connectedSokket, factory);
        threadToStart = factory.createThreadFor(echoLoopInit);
    }

    private void startThread() {
        threadToStart.start();
    }

}
