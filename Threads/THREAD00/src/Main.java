import org.w3c.dom.Text;

public class Main {
    public static void main(String[] args) {
        System.out.println("Fattoriale");
        TestThread tt0 = new TestThread(2);
        TestThread tt1 = new TestThread(5);
        Thread t0 = new Thread(tt0);
        Thread t1 = new Thread(tt1);
        t0.start();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t0.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fact 2: "+ tt0.getFactorial());
        System.out.println("Fact 5: "+ tt1.getFactorial());
    }
}
