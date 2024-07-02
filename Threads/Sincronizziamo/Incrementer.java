package Sincronizziamo;

import java.util.concurrent.Semaphore;

public class Incrementer implements Runnable {
    private Counter counter;
    private Semaphore semaphore;

    public Incrementer(Counter counter, Semaphore semaphore) {
        this.counter = counter;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaphore.acquire();
                System.out.println(counter.increase());
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}