package multithreading.hw37;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdditionWithExecutorService {
    private List<Long> numbers;
    private int threadsNumber;
    private long totalSum;

    public AdditionWithExecutorService(List<Long> numbers, int threadsNumber) {
        this.numbers = numbers;
        this.threadsNumber = threadsNumber;
    }

    private List<Long> getThreadNumbers(int threadIndex) {
        int threshold = numbers.size() / threadsNumber;
        int lowIndex = threadIndex * threshold;
        return numbers.subList(lowIndex, lowIndex + threshold);
    }

    public static void main(String[] args) {
        AdditionWithExecutorService solution = new AdditionWithExecutorService(
                new RandomNumbers(1_000_000).getNumbers(), 10);

        ExecutorService threads
                = Executors.newFixedThreadPool(solution.threadsNumber);
        for (int threadIndex = 0; threadIndex < solution.threadsNumber; threadIndex++) {
            try {
                solution.totalSum += threads.submit(
                                new CustomCallable(solution.getThreadNumbers(threadIndex))).get();
            } catch (InterruptedException | ExecutionException exception) {
                System.out.println("Couldn't execute a sum");
            }
        }
        threads.shutdown();

        System.out.printf("Total sum of %d random numbers = %d. Executed by %s\n",
                solution.numbers.size(), solution.totalSum, solution.getClass().getName());
    }
}
