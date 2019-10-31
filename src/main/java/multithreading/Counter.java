package multithreading;

public class Counter {
    static int number = 0;

    static void increment() {
        while (number < 100) {
            number ++;
        }
    }
}
