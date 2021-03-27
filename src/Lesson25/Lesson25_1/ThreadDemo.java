package Lesson25.Lesson25_1;

import Lesson25.Lesson25_2.SimpleRunnable;

//Порядок выполнения не гарантируется
public class ThreadDemo {
    public static void main(String[] args) {
        var simpleThread = new SimpleThread();
//        simpleThread.interrupt(); ОСТАНОВКА ПОТОКА
        System.out.println(simpleThread.getName() + ": " + simpleThread.getState());
        var runnableThread = new Thread(new SimpleRunnable(), "My name");
        var lambdaThread = new Thread(() -> System.out.println("Hello from lambda: " + Thread.currentThread().getName()));
//        Вызов нового потока и вызов метода Run
        simpleThread.start();
        System.out.println(simpleThread.getName() + ": " + simpleThread.getState());
        runnableThread.start();
        lambdaThread.start();
//        Означает,что поток вызвавший этот метода будет ждать до тех пор пока объект у которого вызвали этот метод не закончит свое выполнение
        try {
            simpleThread.join();
            System.out.println(simpleThread.getName() + ": " + simpleThread.getState());
            runnableThread.join();
            lambdaThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName());
    }
}
