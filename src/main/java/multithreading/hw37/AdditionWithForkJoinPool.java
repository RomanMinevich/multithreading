package multithreading.hw37;

import static java.util.concurrent.ForkJoinPool.commonPool;

import java.util.List;

public class AdditionWithForkJoinPool {
    private List<Long> numbers;
    private int threshold;

    public AdditionWithForkJoinPool(List<Long> numbers, int threshold) {
        this.numbers = numbers;
        this.threshold = threshold;
    }

    public void report() {
        SumExecution.report(numbers.size(), execute(), getClass().getName());
    }

    private long execute() {
        return commonPool().invoke(new CustomRecursiveTask(numbers, threshold));
    }
}
