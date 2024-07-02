package BufferMultiplo;

import java.util.concurrent.Semaphore;

class Buffer {
    private final int[] data;
    private final Semaphore mutex;
    private final Semaphore[] semaphores;

    public Buffer() {
        data = new int[100];
        mutex = new Semaphore(1);
        semaphores = new Semaphore[100];
        for (int i = 0; i < 100; i++) {
            semaphores[i] = new Semaphore(1);
        }
    }

    public int load() throws InterruptedException {
        mutex.acquire();
        int index = -1;
        for (int i = 0; i < 100; i++) {
            semaphores[i].acquire();
            if (data[i] == 0) {
                data[i] = 1;
                index = i;
                break;
            }
            semaphores[i].release();
        }
        mutex.release();
        return index;
    }

    public int consume() throws InterruptedException {
        mutex.acquire();
        int index = -1;
        for (int i = 0; i < 100; i++) {
            semaphores[i].acquire();
            if (data[i] == 1) {
                data[i] = 0;
                index = i;
                break;
            }
            semaphores[i].release();
        }
        mutex.release();
        return index;
    }
}