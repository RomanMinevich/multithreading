package multithreading.hw37;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Random;

public class RandomNumbers {
    private List<Long> numbers;

    public RandomNumbers(int operandsNumber) {
        numbers = new Random().longs(operandsNumber)
                .boxed()
                .collect(toList());
    }

    public List<Long> getNumbers() {
        return numbers;
    }
}