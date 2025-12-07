package semaphore;

import java.util.concurrent.Semaphore;

public class Thread_i extends Thread {

    private int result;
    private Thread_gh thread_g;
    private Thread_gh thread_h;
    private Semaphore aquireSemaphore;
    private Semaphore releaseSemaphore;

    public Thread_i(String name, Thread_gh thread_g, Thread_gh thread_h,
                    Semaphore aquireSemaphore, Semaphore releaseSemaphore) {
        super(name);
        this.thread_g = thread_g;
        this.thread_h = thread_h;
        this.aquireSemaphore = aquireSemaphore;
        this.releaseSemaphore = releaseSemaphore;
    }

    @Override
    public void run() {
        try {
            aquireSemaphore.acquire(2);
            System.out.println("Starte Berechnung für " + this.getName() + ": "
                    + thread_g.getResult() + " * " + thread_h.getResult());
            // simulate workload (1-3 sec)
            Thread.sleep((long) (Math.random() * 2000 + 1000));;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        result = thread_g.getResult() * thread_h.getResult();
        System.out.println(getName() + " berechnet: " + result);
        releaseSemaphore.release();
    }
    public int getResult() {
        return result;
    }
}
