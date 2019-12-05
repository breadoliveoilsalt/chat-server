import chatServer.factory.ChatServerAppFactory;
import chatServer.logic.ChatServerInit;

import java.io.IOException;

class App {

    public static void main(String[] args) throws IOException {
        int port = 8000;
        chatServer.interfaces.AppFactory factory = new ChatServerAppFactory();

        new ChatServerInit(port, factory).start();
    }

}