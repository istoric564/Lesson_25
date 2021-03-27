package Lesson25_Practice;

import java.util.Queue;

public class ConsumerThread implements Runnable {
    private final Queue<Integer> list;

    public ConsumerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (!list.isEmpty()){
                    Integer remove = list.remove();
                    System.out.println("consumer get value: " + remove + ". Size: " + list.size());
                }else {
                    System.out.println("consumer is waiting, lis is empty");
                }

                try {
                    int random = 80;
                    System.out.println("Consumer wait: " + random);
                    list.wait(random);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
