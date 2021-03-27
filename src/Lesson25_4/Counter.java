package Lesson25_4;

/**
 * 1. Создать класс Counter с одним полем:
 * private int count;
 * <p>
 * Добавить методы:
 * - getCount() - для получение поля count
 * - increment() - для увеличения значения поля на единицу
 * - decrement() - для уменьшения значения поля на единицу
 * <p>
 * synchronized - только один объект может вызвать этот метод. Позволяет сделать любую операцию атомарной.
 */
public class Counter {

    private static String description;
    private int count;

    private static void init() {
        synchronized (Counter.class) {
            if (description == null) {
                description = "Test description";
            }
        }
    }

    // Монитор - средство обеспечения контроля за доступом к объекту.
    public void increment() {
        synchronized (this) {
            count++;
        }

    }

    public synchronized int decrement() {
        return this.count--;
    }

    public int getCount() {
        return count;
    }


}
