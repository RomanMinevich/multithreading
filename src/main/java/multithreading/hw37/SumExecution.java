package multithreading.hw37;

import java.util.List;

public class SumExecution {

    public static long executeSum(List<Long> numbers) {
        return numbers.stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    public static void report(int listSize, long sum, String executorName) {
        System.out.printf("Total sum of %d random numbers = %d. Executed by %s\n",
                listSize, sum, executorName);
    }
}
