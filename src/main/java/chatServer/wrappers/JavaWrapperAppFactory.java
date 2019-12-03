package chatServer.wrappers;

import chatServer.interfaces.*;
import chatServer.logic.EchoLoop;
import chatServer.logic.EchoLoopClientWelcome;
import chatServer.logic.EchoLoopInit;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class JavaWrapperAppFactory implements AppFactory {

    public JavaServerSocketWrapper createServerSokketListeningAtPort(int port) throws IOException {
        return new JavaServerSocketWrapper(port);
    }

    public JavaBufferedReaderWrapper createReader(InputStream inputStream) {
        return new JavaBufferedReaderWrapper(inputStream);
    }

    public JavaPrintWriterWrapper createWriter(OutputStream outputStream) {
        return new JavaPrintWriterWrapper(outputStream);
    }

    public Runnable createEchoLoopInit(Sokket connectedSokket, AppFactory factory) {
        return new EchoLoopInit(connectedSokket, factory);
    }

    public ClientProtocol createWelcome(Writer writer) {
       return new EchoLoopClientWelcome(writer);
    }

    public ClientProtocol createEchoLoop(Reader reader, Writer writer) {
        return new EchoLoop(reader, writer);
    }

    public Thread createThreadFor(Runnable runnable) {
        return new Thread(runnable);
    }
}
