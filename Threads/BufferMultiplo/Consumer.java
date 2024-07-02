package BufferMultiplo;

class Consumer implements Runnable {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (50 + Math.random() * 150));
                int index = buffer.consume();
                System.out.println("Consumato all'indice: " + index);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}