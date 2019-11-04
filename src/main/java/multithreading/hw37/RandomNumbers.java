package multithreading.hw37;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class RandomNumbers implements Supplier<List<Long>> {
    private List<Long> numbers;

    public RandomNumbers(int size) {
        numbers = new Random().longs(size)
                .boxed()
                .collect(toList());
    }

    @Override
    public List<Long> get() {
        return numbers;
    }
}
