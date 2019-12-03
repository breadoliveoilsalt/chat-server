package mocks;

public class MockThread extends Thread {

    private final Runnable mockEchoInit;

    public MockThread(Runnable mockEchoInit) {
        this.mockEchoInit = mockEchoInit;
    }
    private int callCountForStart = 0;

    public int getCallCountForStart() {
        return callCountForStart;
    }

    @Override
    public void start() {
        callCountForStart += 1;
        mockEchoInit.run();
    }

}
