package multithreading.hw36;

public class ThreadExt extends Thread {
    private int number;

    public ThreadExt(Counter counter) {
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
