package CalcoloParallelo;
import java.util.ArrayList;

public class Massimo implements Runnable {
    ArrayList<Float> ar = new ArrayList<>();

    Massimo(ArrayList<Float> ar) {
        this.ar = ar;
    }

    @Override
    public void run() {
        float max = ar.get(0);
        for (int i = 0; i < ar.size(); i++) {
            if (max < ar.get(i)) {
                max = ar.get(i);
            }
        }
        System.out.println("Il valore massimo è: " + max);
    }
}
