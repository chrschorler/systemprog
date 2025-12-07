package semaphore;

import java.util.concurrent.Semaphore;

public class Thread_u extends Thread {

    private int result;
    private Thread_ayz thread_y;
    private Thread_ayz thread_z;
    private Semaphore aquireSemaphore;

    public Thread_u(String name, Thread_ayz thread_y, Thread_ayz thread_z,
                    Semaphore aquireSemaphore) {
        super(name);
        this.thread_y = thread_y;
        this.thread_z = thread_z;
        this.aquireSemaphore = aquireSemaphore;
    }

    @Override
    public void run() {
        try {
            aquireSemaphore.acquire(2);
            System.out.println("Starte Berechnung für " + this.getName() + ": "
                    + thread_y.getResult() + " * " + thread_z.getResult());
            // simulate workload (1-3 sec)
            Thread.sleep((long) (Math.random() * 2000 + 1000));;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        result = thread_y.getResult() * thread_z.getResult();
        System.out.println(getName() + " berechnet: " + result );
    }

    public int getResult() {
        return result;
    }
}
