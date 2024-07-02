package Concorrenza;

public class Main {
    public static void main(String[] args) {
        int nc = 5;

        Producer p = new Producer();

        Consumer c[] = new Consumer[5];
        for (int i = 0; i < nc; i++) {
            c[i] = new Consumer(p);
        }

        Thread tp = new Thread(p);
        Thread tc[] = new Thread[nc];
        for (int i = 0; i < nc; i++) {
            tc[i] = new Thread(c[i]);
        }

        try {
            tp.start();

            for (int i = 0; i < nc; i++) {
                tc[i].start();
            }

            for (int i = 0; i < nc; i++) {
                tc[i].join();
            }

            int somma = 0;
            for (int i = 0; i < nc; i++) {
                somma += c[i].getSomma();
            }
            System.out.println(somma);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
