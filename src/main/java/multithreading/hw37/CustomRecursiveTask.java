package multithreading.hw37;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Long> {
    private List<Long> numbers;
    private int threshold;

    public CustomRecursiveTask(List<Long> numbers, int threshold) {
        this.numbers = numbers;
        this.threshold = threshold;
    }

    @Override
    protected Long compute() {
        if (numbers.size() > threshold) {
            return divide();
        }
        long sum = SumExecution.executeSum(numbers);
        SumExecution.report(numbers.size(), sum, Thread.currentThread().getName());
        return sum;
    }

    private Long divide() {
        CustomRecursiveTask task1 = new CustomRecursiveTask(
                numbers.subList(0, numbers.size() / 2), threshold);
        task1.fork();
        CustomRecursiveTask task2 = new CustomRecursiveTask(
                numbers.subList(numbers.size() / 2, numbers.size()), threshold);
        return task2.compute() + task1.join();
    }
}
