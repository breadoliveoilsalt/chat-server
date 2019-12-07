package mocks2;

public class TestableThread extends Thread {

    int callCountForStart = 0;
    public int getCallCountForStart() {
        return callCountForStart;
    }


    private Runnable runnablePassedToThread;
    public Runnable getRunnablePassedToThread() {
        return runnablePassedToThread;
    }

    public TestableThread() {};
    public TestableThread(Runnable runnable) {
        this.runnablePassedToThread = runnable;
    }

    @Override
    public void start() {
        callCountForStart += 1;
        runnablePassedToThread.run();
    }

    public Thread establishWithRunnable(Runnable runnable) {
        this.runnablePassedToThread = runnable;
        return this;
    }

}
