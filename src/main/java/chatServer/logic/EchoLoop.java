package chatServer.logic;

import chatServer.interfaces.*;

import java.io.IOException;

public class EchoLoop implements ClientProtocol {

    private final Reader reader;
    private final Writer writer;
    private final String clientName;

    public EchoLoop(Reader reader, Writer writer, String name) {
        this.reader = reader;
        this.writer = writer;
        this.clientName = name;
    }

    public void run() throws IOException {
        String clientMessage = reader.readLine();
        while (!clientMessage.equals("exit!")) {
            writer.printLine(clientName + ": " + clientMessage);
            clientMessage = reader.readLine();
        }
    }

}
