package Lesson25.Lesson25_1;

public class SimpleThread extends Thread{
    @Override
    public void run() {
        System.out.println("Hello " + getName());
    }
}

