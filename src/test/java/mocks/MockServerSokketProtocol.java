package mocks;

import echoServer.interfaces.AppFactory;
import echoServer.interfaces.ServerSokket;
import echoServer.interfaces.ServerSokketProtocol;

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
