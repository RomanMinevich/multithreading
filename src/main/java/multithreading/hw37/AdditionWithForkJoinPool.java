package multithreading.hw37;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

public class AdditionWithForkJoinPool {
    private List<Long> numbers;
    private int threshold = 10_000;

    public AdditionWithForkJoinPool(List<Long> numbers, int threshold) {
        this.numbers = numbers;
        this.threshold = threshold;
    }

    private List<CustomRecursiveTask> getTasks(List<Long> numbers) {
        List<CustomRecursiveTask> tasks = new ArrayList<>();
        for (int index = 0; index < numbers.size() - 1; index += threshold) {
            tasks.add(new CustomRecursiveTask(numbers.subList(index, index + threshold)));
        }
        return tasks;
    }

    public static void main(String[] args) {
        AdditionWithForkJoinPool solution = new AdditionWithForkJoinPool(
                        new RandomNumbers(1_000_000).getNumbers(), 10_000);

        long totalSum = solution.getTasks(solution.numbers)
                .stream()
                .map(ForkJoinTask::invoke)
                .mapToLong(Long::valueOf)
                .sum();

        System.out.printf("Total sum of %d random numbers = %d Executed by %s\n",
                solution.numbers.size(), totalSum,
                AdditionWithForkJoinPool.class.getName());
    }
}
