package multithreading.hw37;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AdditionWithExecutorService {
    private List<Long> numbers;
    private int threadsNumber;

    public AdditionWithExecutorService(List<Long> numbers, int threadsNumber) {
        this.numbers = numbers;
        this.threadsNumber = threadsNumber;
    }

    public void report() {
        SumExecution.report(numbers.size(), execute(), getClass().getName());
    }

    private long execute() {
        ExecutorService threads = Executors.newFixedThreadPool(threadsNumber);
        List<Callable<Long>> tasks = new ArrayList<>();
        long totalSum = 0;
        for (int threadIndex = 0; threadIndex < threadsNumber; threadIndex++) {
            tasks.add(new CustomCallable(getThreadNumbers(threadIndex)));
        }
        try {
            for (Future<Long> taskSum : threads.invokeAll(tasks)) {
                totalSum += taskSum.get();
            }
        } catch (InterruptedException | ExecutionException exception) {
            System.out.println(getClass().getName() + " : couldn't execute sum");
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
