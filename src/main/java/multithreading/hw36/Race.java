package multithreading.hw36;

public class Race {

    public static void main(String[] args) {
        Counter counter = new Counter(0);
        new ThreadExt(counter).start();
        new Thread(new RunnableImpl(counter)).start();
    }
}
