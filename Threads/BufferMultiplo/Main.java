package BufferMultiplo;

public class Main {
    public static void main(String[] args) {    
        Buffer buffer = new Buffer();
        int numProducers = 5;
        int numConsumers = 5;
            
        for (int i = 0; i < numProducers; i++) {
            Thread producerThread = new Thread(new Producer(buffer));
            producerThread.start();
        }

        for (int i = 0; i < numConsumers; i++) {
            Thread consumerThread = new Thread(new Consumer(buffer));
            consumerThread.start();
        }
    }
}