package multithreading;

public class Race {

    public static void main(String[] args) {
        Counter counter = new Counter();
        new ThreadExt(counter).start();
        new Thread(new RunnableImpl(counter)).start();
        System.out.println(counter.getNumber());
    }
}
