package multithreading;

public class Race {

    public static void main(String[] args) {
        new ThreadExt().start();
        new RunnableImpl().run();
        System.out.println(Counter.number);
    }
}
