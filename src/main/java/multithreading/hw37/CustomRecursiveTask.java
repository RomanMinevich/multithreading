package multithreading.hw37;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Long> {
    private List<Long> numbers;

    public CustomRecursiveTask(List<Long> numbers) {
        this.numbers = numbers;
    }

    @Override
    protected Long compute() {
        long sum = SumExecution.execute(numbers);
        SumExecution.report(numbers.size(), sum, Thread.currentThread().getName());
        return sum;
    }
}
