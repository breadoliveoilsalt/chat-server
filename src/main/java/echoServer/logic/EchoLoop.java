package echoServer.logic;

import echoServer.interfaces.*;

import java.io.IOException;

public class EchoLoop implements ClientProtocol {

    private final Reader reader;
    private final Writer writer;

    public EchoLoop(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void run() throws IOException {
        String clientMessage = reader.readLine();
        while (!clientMessage.equals("exit!")) {
            writer.printLine(clientMessage);
            clientMessage = reader.readLine();
        }
    }

}
