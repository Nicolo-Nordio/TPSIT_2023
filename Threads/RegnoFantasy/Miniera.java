package RegnoFantasy;

import java.util.Random;

public class Miniera {
    private boolean type; // True = ferro & False = carbone
    private int numMateriali; // Vena
    private Random random;

    Miniera(boolean type) {
        this.type = type;
        random = new Random();
        numMateriali = random.nextInt(1, 10);
    }

    public int getNumMateriali() {
        return numMateriali;
    }

}
