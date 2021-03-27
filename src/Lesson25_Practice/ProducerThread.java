package Lesson25_Practice;

import java.util.Queue;

public class ProducerThread implements Runnable {

    private final Queue<Integer> list;

    public ProducerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if(list.size() < 10){
                    int random = RandomUtil.getRandom();
                    list.add(random);
                    System.out.println("producer adds value: " + random + ". Size: " + list.size());
                } else {
                    System.out.println("Producer does nothing");
                }
                try {
                    int randomWaitValue = 20;
                    System.out.println("producer waits value: " + randomWaitValue);
                    list.wait(randomWaitValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
