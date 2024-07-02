package Sincronizziamo;

public class Counter {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public int increase() {
        count++;
        return count;
    }

    public int decrease() {
        if (count > 0) {
            count--;
        }
        return count;
    }

    public int getCount() {
        return count;
    }
}