public class Main {
    public static void main(String[] args) {
        System.out.println("Multipli: ");
        Multiplier m0 = new Multiplier(10);
        Multiplier m1 = new Multiplier(5);
        Thread t0 = new Thread(m0);
        Thread t1 = new Thread(m1);

        t0.start();
        t1.start();
        try {
            t0.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
