package Lesson25_9;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class BuyerThread implements Runnable {

    private final Semaphore cashBoxes;

    public BuyerThread(Semaphore cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {

        try {
            cashBoxes.acquire();

            System.out.println(Thread.currentThread().getName() + " обслуживается в кассе ");
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " освобождаю кассу ");
            cashBoxes.release();
//            synchronized (cashBoxes) {
//                while (true) {
//                    if (!cashBoxes.isEmpty()) {
//                        CashBox cashBox = cashBoxes.remove();
//                        System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashBox);
//
//                        cashBoxes.wait(10L);
//
//                        System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashBox);
//                        cashBoxes.add(cashBox);
//                        cashBoxes.notifyAll();
//                        break;
//                    } else {
//                        System.out.println(Thread.currentThread().getName() + " ожидает свободную кассу");
//                        cashBoxes.wait();
//                    }
//                }
//            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
