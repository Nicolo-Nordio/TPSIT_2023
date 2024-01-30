public class TestThread implements Runnable{

    private int n;
    private int nFact;

    TestThread(int n){
        this.n = n;
    }

    public int getFactorial() {
        return nFact;
    }

    private int fact(int n){
        if (n == 1){
            return 1;
        }else {
            return n * fact(n-1);
        }
    }

    @Override
    public void run() {
        this.nFact = fact(n);
    }
}
