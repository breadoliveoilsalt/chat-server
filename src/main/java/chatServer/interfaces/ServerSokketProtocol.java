package chatServer.interfaces;

import java.io.IOException;

public interface ServerSokketProtocol {

    void run(ServerSokket serverSokket, AppFactory factory) throws IOException;

}
