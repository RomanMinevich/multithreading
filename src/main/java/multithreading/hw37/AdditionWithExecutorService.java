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

    public void report() {
        SumExecution.report(numbers.size(), execute(), getClass().getName());
    }

    private long execute() {
        ExecutorService threads = Executors.newFixedThreadPool(threadsNumber);
        for (int threadIndex = 0; threadIndex < threadsNumber; threadIndex++) {
            try {
                totalSum += threads.submit(
                        new CustomCallable(getThreadNumbers(threadIndex))).get();
            } catch (InterruptedException | ExecutionException exception) {
                System.out.println(getClass().getName() + " : couldn't execute sum");
            }
        }
        threads.shutdown();
        return totalSum;
    }

    private List<Long> getThreadNumbers(int threadIndex) {
        int threshold = numbers.size() / threadsNumber;
        int lowIndex = threadIndex * threshold;
        return numbers.subList(lowIndex, lowIndex + threshold);
    }
}
