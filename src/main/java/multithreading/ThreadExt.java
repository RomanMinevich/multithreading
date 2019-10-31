package multithreading;

public class ThreadExt extends Thread {

    @Override
    public void run() {
        Counter.increment();
    }
}
