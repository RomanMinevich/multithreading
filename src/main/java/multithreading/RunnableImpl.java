package multithreading;

public class RunnableImpl implements Runnable {

    public void run() {
        Counter.increment();
    }
}
