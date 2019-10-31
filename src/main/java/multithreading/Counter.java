package multithreading;

public class Counter {
    private int number;

    void increment() {
        while (number < 100) {
            number++;
        }
    }

    public int getNumber() {
        return number;
    }
}
