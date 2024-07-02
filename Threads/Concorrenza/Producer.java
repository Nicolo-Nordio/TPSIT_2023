package Concorrenza;

public class Producer implements Runnable {

    private int counter;
    private boolean isEnded;

    Producer() {
        this.counter = 0;
        this.isEnded = false;
    }

    public int get() {
        if (this.counter > 0) {
            this.counter = this.counter - 1;
            return 1;
        } else if (this.counter == 0) {
            if (this.isEnded) return -1;
            else return 0;
        } else{
            return 0;
        }

        /*
         * if (this.counter == 0 && this.isEnded) {
         * return -1;
         * } else if (this.counter == 0) {
         * return 0;
         * } else {
         * this.counter = this.counter - 1;
         * return 1;
         * }
        */
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            this.counter = this.counter + 1;
        }

        this.isEnded = true;
    }
}
