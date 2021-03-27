package Lesson25_4;

/**
 *
 2. Создать класс CounterThread c одним полем и конструктором для инициализации:
 private Counter counter;
 */
public class CounterThread extends Thread{
    private final Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
