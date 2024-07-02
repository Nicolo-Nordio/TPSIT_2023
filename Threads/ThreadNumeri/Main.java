package ThreadNumeri;

public class Main {
    public static void main(String[] args) {
        System.out.println("Numeri da 1 a 10, da 100 a 50");
        Test tt0 = new Test(true);
        Test tt1 = new Test(false);
        Thread t0 = new Thread(tt0);
        Thread t1 = new Thread(tt1);

        t0.start();
        t1.start();

        try {
            t0.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}