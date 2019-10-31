package multithreading;

public class ThreadExt extends Thread {
    private Counter counter;

    public ThreadExt(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.increment();
    }
}
