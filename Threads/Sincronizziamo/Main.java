package Sincronizziamo;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Semaphore semaphore = new Semaphore(1);

        Thread incrementerThread = new Thread(new Incrementer(counter, semaphore));
        Thread decrementerThread1 = new Thread(new Decrementer(counter, semaphore));
        Thread decrementerThread2 = new Thread(new Decrementer(counter, semaphore));

        incrementerThread.start();
        decrementerThread1.start();
        decrementerThread2.start();
    }
}