package RegnoFantasy;

public class Minatore implements Runnable{
    private int mineraliRaccolti;
    private Miniera min;

    Minatore(Miniera min){
        this.min = min;
        numMaterialiRaccolti = 0;
    }

    @Override
    public void run(){
        while (numMaterialiRaccolti != min.getNumMateriali()) {
            numMaterialiRaccolti++;
        }
    }
}
