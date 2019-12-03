package chatServer.logic;

import chatServer.interfaces.AppFactory;
import chatServer.interfaces.ServerSokket;
import chatServer.interfaces.ServerSokketProtocol;

import java.io.IOException;

public class EchoServerInit {

    private final int port;
    private final ServerSokketProtocol protocol;
    private final AppFactory factory;
    private ServerSokket serverSokket;

    public EchoServerInit(int port, ServerSokketProtocol protocol, AppFactory factory) {
        this.port = port;
        this.protocol = protocol;
        this.factory = factory;
    }

    public void start() throws IOException {

        try {
            initializeServerSokket();
            runServerSokketProtocol();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeServerSokket();
        }

    }

    private void initializeServerSokket() throws IOException {
        serverSokket = factory.createServerSokketListeningAtPort(port);
    }

    private void runServerSokketProtocol() throws IOException {
        protocol.run(serverSokket, factory);
    }

    private void closeServerSokket() throws IOException {
        serverSokket.close();
    }

}
