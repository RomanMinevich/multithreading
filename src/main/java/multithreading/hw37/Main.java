package multithreading.hw37;

public class Main {
    private static final int LIST_SIZE = 1_000_000;
    private static final int EXECUTOR_SERVICE_POOL_SIZE = 10;
    private static final int FORK_JOIN_TASK_LIST_SIZE = 10_000;

    public static void main(String[] args) {
        new AdditionWithExecutorService(
                new RandomNumbers(LIST_SIZE).get(), EXECUTOR_SERVICE_POOL_SIZE)
                .report();
        System.out.println();
        new AdditionWithForkJoinPool(
                new RandomNumbers(LIST_SIZE).get(), FORK_JOIN_TASK_LIST_SIZE)
                .report();
    }
}
