package semaphore;

import java.util.concurrent.Semaphore;

public class Thread_v extends Thread {

    private int result;
    private Thread_ayz thread_a;
    private Thread_i thread_i;
    private Semaphore aquireSemaphore;

    public Thread_v(String name, Thread_ayz thread_a, Thread_i thread_i,
                    Semaphore aquireSemaphore) {
        super(name);
        this.thread_a = thread_a;
        this.thread_i = thread_i;
        this.aquireSemaphore = aquireSemaphore;
    }

    @Override
    public void run() {
        try {
            aquireSemaphore.acquire(2);
            System.out.println("Starte Berechnung für " + this.getName() + ": "
                    + thread_a.getResult() + " * " + thread_i.getResult());
            // simulate workload (1-3 sec)
            Thread.sleep((long) (Math.random() * 2000 + 1000));;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        result = thread_a.getResult() * thread_i.getResult();
        System.out.println(getName() + " berechnet: " + result );
    }

    public int getResult() {
        return result;
    }
}
