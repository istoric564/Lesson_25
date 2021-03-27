package Lesson25_10;

public class AccountDemo {
    public static void main(String[] args) {
        Account firstAccount = new Account(20000);
        Account secondAccount = new Account(20000);

        AccountThread accountThreadFirst = new AccountThread(firstAccount, secondAccount);
        AccountThread accountThreadSecond = new AccountThread(secondAccount, firstAccount);

        accountThreadFirst.start();
        accountThreadSecond.start();

        try {
            accountThreadFirst.join();
            accountThreadSecond.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(firstAccount);
        System.out.println(secondAccount);
    }
}
