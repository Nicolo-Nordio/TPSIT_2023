

public class Multiplier implements Runnable {
    private int n;

    Multiplier(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < 999; i++) {
            System.out.println("Il multiplo di " + n + " è:" + n * i);
            Thread.yield();
        }
    };
}
