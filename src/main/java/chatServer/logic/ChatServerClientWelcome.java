package chatServer.logic;

import chatServer.interfaces.Reader;
import chatServer.interfaces.Writer;

import java.io.IOException;

public class ChatServerClientWelcome {

    private final Writer writer;
    private final Reader reader;

    public ChatServerClientWelcome(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public String getClientName() throws IOException {
        writer.printLine(
            "\n *** Welcome to Echo Server! *** \n" +
            "\n *** What is your name? *** \n");
        return reader.readLine();
    }

    public void printInstructions() {
        writer.printLine(
            "\n *** Type away, hit return, and watch your wisdom come back at you! *** \n" +
            "\n *** Type 'exit!' and hit return to disconnect *** \n"
        );

    }
}
