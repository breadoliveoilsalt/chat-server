package chatServer.logic;

import chatServer.interfaces.*;

import java.io.IOException;

public class EchoServerListeningLoop implements ServerSokketProtocol {

    private Sokket connectedSokket;
    private Thread threadToStart;

    @Override
    public void run(ServerSokket serverSokket, AppFactory factory) throws IOException {
        while (serverSokket.isBoundToAPort()) {
            getSokketConnectedToClient(serverSokket);
            initializeThreadedEchoLoop(factory);
            startThread();
        }
    }

    private void getSokketConnectedToClient(ServerSokket serverSokket) throws IOException {
        connectedSokket = serverSokket.acceptConnectionAndReturnConnectedSokket();
    }

    private void initializeThreadedEchoLoop(AppFactory factory) {
        Runnable echoLoopInit = factory.createEchoLoopInit(connectedSokket, factory);
        threadToStart = factory.createThreadFor(echoLoopInit);
    }

    private void startThread() {
        threadToStart.start();
    }

}
