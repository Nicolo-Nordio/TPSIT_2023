

public class Main {
    public static void main(String[] args) {
        Thread t0 = new Thread(new Multiplier(2));
        
        Thread t1 = new Thread(new Multiplier(3));
        
        Thread t2 = new Thread(new Multiplier(4));
        
        Thread t3 = new Thread(new Multiplier(5));

        t0.start();
        t0.join();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t4.join();
    }
}
