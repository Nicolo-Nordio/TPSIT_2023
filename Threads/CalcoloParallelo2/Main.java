package CalcoloParallelo2;

//Fase 2
public class Main {
    public static void main(String[] args) {
        double somma;
        
        double[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Worker worker1 = new Worker(array, 0, 3);
        Thread t1 = new Thread(worker1);
        Worker worker2 = new Worker(array, 3, 6);
        Thread t2 = new Thread(worker2);
        Worker worker3 = new Worker(array, 6, 10);
        Thread t3 = new Thread(worker3);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        somma = worker1.getSomma() + worker2.getSomma() + worker3.getSomma();
        System.out.println("La somma è: " + somma);
    }
}
