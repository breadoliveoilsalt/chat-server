package chatServer.logic;

import chatServer.interfaces.ClientProtocol;
import chatServer.interfaces.Writer;

public class EchoLoopClientWelcome implements ClientProtocol {

    private final Writer writer;

    public EchoLoopClientWelcome(Writer writer) {
        this.writer = writer;
    }

    public void run() {
        writer.printLine(
            "\n *** Welcome to Echo Server! *** \n" +
            "\n *** Type away, hit return, and watch your wisdom come back at you! *** \n" +
            "\n *** Type 'exit!' and hit return to disconnect *** \n"
        );
    }

}
