import java.util.Arrays;

public class Multiplier implements Runnable {

    private int n;
    private int multi;

    Multiplier(int n){
        this.n = n;
    }

    @Override
    public void run() {
        multi = n;
        for (int i = 0; i < 1000; i++) {
            System.out.println(multi);
            multi += n;
            Thread.yield();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
