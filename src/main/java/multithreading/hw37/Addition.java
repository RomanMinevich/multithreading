package multithreading.hw37;

import java.util.List;

public interface Addition {

    static long execute(List<Long> numbers) {
        return numbers.stream()
                .mapToLong(Long::longValue)
                .sum();
    }
}
