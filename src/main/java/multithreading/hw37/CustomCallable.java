package multithreading.hw37;

import java.util.List;
import java.util.concurrent.Callable;

public class CustomCallable implements Callable<Long> {
    private List<Long> numbers;

    public CustomCallable(List<Long> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Long call() {
        long sum = SumExecution.execute(numbers);
        SumExecution.report(numbers.size(), sum, Thread.currentThread().getName());
        return sum;
    }
}
