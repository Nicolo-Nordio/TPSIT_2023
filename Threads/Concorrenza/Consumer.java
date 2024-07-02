package Concorrenza;

public class Consumer implements Runnable {

    private Producer producer;
    private int somma;

    Consumer(Producer producer) {
        this.producer = producer;
        this.somma = 0;
    }

    public int getSomma() {
        return this.somma;
    }

    @Override
    public void run() {
        int n;

        do {
            n = this.producer.get();
            if (n != -1) this.somma = this.somma + n;
        } while (n != -1);
    }
}