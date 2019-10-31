package multithreading;

public class Counter {
    private int number;

    void increment() {
        while (number < 100) {
            number ++;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
