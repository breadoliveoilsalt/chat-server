package mocks;

import chatServer.interfaces.Reader;
import chatServer.interfaces.Writer;
import chatServer.logic.EchoLoopClientWelcome;

public class MockClientWelcome extends EchoLoopClientWelcome {

    public MockClientWelcome(Writer writer, Reader reader) {
        super(writer, reader);
    }

    private int callCountForGetClientName = 0;
    public int getCallCountForGetClientName() {
        return callCountForGetClientName;
    }

    private int callCountForPrintInstructions = 0;
    public int getCallCountForPrintInstructions() {
        return callCountForPrintInstructions;
    }

    private String name = "";
    public String getName() {
        return name;
    }
    public void setNameToReturn(String name) {
        this.name = name;
    }

    @Override
    public String getClientName() {
        callCountForGetClientName += 1;
        return name;
    }

    @Override
    public void printInstructions() {
        callCountForPrintInstructions += 1;
    }
}
