package multithreading;

public class RunnableImpl implements Runnable {
    private int number;

    public RunnableImpl(Counter counter) {
        number = counter.getNumber();
    }

    @Override
    public void run() {
        while (number < 100) {
            number++;
            System.out.println(Thread.currentThread().getName() + " : " + number);
        }
    }
}
