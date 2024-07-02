package CalcoloParallelo2;

public class Worker implements Runnable{

    private double[] ar;
    private int min;
    private int max;
    private int somma = 0;

    Worker(double[] array, int min, int max){
        ar = array; 
        this.min = min;
        this.max = max;
    }

    public double getSomma(){
        for (int i = this.min; i < this.max; i++) {
            somma += ar[i];
        }
        return somma;
    }

    @Override
    public void run() {
        
    }
}