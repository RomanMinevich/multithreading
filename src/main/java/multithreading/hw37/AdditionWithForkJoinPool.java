package multithreading.hw37;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

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
        return ForkJoinTask.invokeAll(getTasks()).stream()
                .map(ForkJoinTask::invoke)
                .mapToLong(Long::valueOf)
                .sum();
    }

    private List<CustomRecursiveTask> getTasks() {
        List<CustomRecursiveTask> tasks = new ArrayList<>();
        for (int index = 0; index < numbers.size() - 1; index += threshold) {
            tasks.add(new CustomRecursiveTask(numbers.subList(index, index + threshold)));
        }
        return tasks;
    }
}
