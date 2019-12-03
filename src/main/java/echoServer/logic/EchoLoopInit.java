package echoServer.logic;

import echoServer.interfaces.*;

import java.io.IOException;

public class EchoLoopInit implements Runnable, ClientProtocol {

    private final Sokket sokket;
    private final AppFactory factory;
    private Reader reader;
    private Writer writer;

    public EchoLoopInit(Sokket sokket, AppFactory factory) {
        this.sokket = sokket;
        this.factory = factory;
    }

    public void run() {
        try {
            initReaderAndWriter();
            welcomeClient();
            runEchoLoop();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeReaderAndWriter();
            try {
                closeSokket();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initReaderAndWriter() throws IOException {
        reader = factory.createReader(sokket.getInputStream());
        writer = factory.createWriter(sokket.getOutputStream());
    }

    private void welcomeClient() throws IOException {
        ClientProtocol welcomer = factory.createWelcome(writer);
        welcomer.run();
    }

    private void runEchoLoop() throws IOException {
        ClientProtocol echoLoop = factory.createEchoLoop(reader, writer);
        echoLoop.run();
    }

    private void closeReaderAndWriter() {
        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeSokket() throws IOException {
        sokket.close();
    }

}
