package BufferMultiplo;

class Producer implements Runnable {
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (100 + Math.random() * 100));
                int index = buffer.load();
                System.out.println("Prodotto all'indice "+ index);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}