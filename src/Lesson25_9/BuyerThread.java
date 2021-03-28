package Lesson25_9;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class BuyerThread implements Runnable {

    private final BlockingQueue<CashBox> cashBoxes;

    public BuyerThread(BlockingQueue<CashBox> cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {

        try {
            CashBox cashBox = cashBoxes.take();
            System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashBox);
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashBox);
            cashBoxes.add(cashBox);
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
