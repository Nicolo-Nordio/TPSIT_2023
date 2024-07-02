package ThreadNumeri;
public class Test implements Runnable {
    private boolean scelta;

    Test(boolean scelta) {
        this.scelta = scelta;
    }

    @Override
    public void run() {
        if (scelta) {
            for (int i = 1; i <= 10; i++) {
                System.out.print(i);
                Thread.yield();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            for (int i = 100; i >= 50; i--) {
                System.out.println("\t"+i);
                Thread.yield();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
