import chatServer.interfaces.AppFactory;
import chatServer.interfaces.ServerSokketProtocol;
import chatServer.logic.EchoServerInit;
import chatServer.logic.EchoServerListeningLoop;
import chatServer.wrappers.JavaWrapperAppFactory;

import java.io.IOException;

class App {

    public static void main(String[] args) throws IOException {
        int port = 8000;
        ServerSokketProtocol echoServerProtocol = new EchoServerListeningLoop();
        AppFactory factory = new JavaWrapperAppFactory();

        new EchoServerInit(port, echoServerProtocol, factory).start();
    }

}