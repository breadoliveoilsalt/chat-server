import chatServer.interfaces.AppFactory;
import chatServer.logic.ChatServerInit;
import chatServer.wrappers.JavaWrapperAppFactory;

import java.io.IOException;

class App {

    public static void main(String[] args) throws IOException {
        int port = 8000;
        AppFactory factory = new JavaWrapperAppFactory();

        new ChatServerInit(port, factory).start();
    }

}