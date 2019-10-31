package multithreading;

public class RunnableImpl implements Runnable {
    private Counter counter;

    public RunnableImpl(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.increment();
    }
}
