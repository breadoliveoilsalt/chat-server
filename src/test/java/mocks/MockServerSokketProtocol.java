package mocks;

import chatServer.interfaces.AppFactory;
import chatServer.interfaces.ServerSokket;
import chatServer.interfaces.ServerSokketProtocol;

public class MockServerSokketProtocol implements ServerSokketProtocol {

    private ServerSokket serverSokketArgument;
    public ServerSokket getServerSokketArgument() {
        return serverSokketArgument;
    }

    private AppFactory factoryArgument;
    public AppFactory getFactoryArgument() {
        return factoryArgument;
    }

    private int callCountForRun = 0;
    public int getCallCountForRun() {
        return callCountForRun;
    }


    @Override
    public void run(ServerSokket serverSokket, AppFactory factory) {
        this.serverSokketArgument = serverSokket;
        this.factoryArgument = factory;
        this.callCountForRun += 1;
    }

}
