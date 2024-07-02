package CalcoloParallelo;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Float> ar = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ar.add(rand.nextFloat(0f, 1000000f));
        }
    }
}