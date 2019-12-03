import echoServer.interfaces.AppFactory;
import echoServer.interfaces.ServerSokketProtocol;
import echoServer.logic.EchoServerInit;
import echoServer.logic.EchoServerListeningLoop;
import echoServer.wrappers.JavaWrapperAppFactory;

import java.io.IOException;

class App {

    public static void main(String[] args) throws IOException {
        int port = 8000;
        ServerSokketProtocol echoServerProtocol = new EchoServerListeningLoop();
        AppFactory factory = new JavaWrapperAppFactory();

        new EchoServerInit(port, echoServerProtocol, factory).start();
    }

}