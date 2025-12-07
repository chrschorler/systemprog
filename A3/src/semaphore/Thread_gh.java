package semaphore;

import java.util.concurrent.Semaphore;

public class Thread_gh extends Thread {

    private int operand;
    private int result;
    private Thread_d thread_d;
    private Semaphore aquireSemaphore;
    private Semaphore releaseSemaphore;

    public Thread_gh(String name, Thread_d thread_d, int operand,
                     Semaphore aquireSemaphore, Semaphore releaseSemaphore) {
        super(name);
        this.operand = operand;
        this.thread_d = thread_d;
        this.aquireSemaphore = aquireSemaphore;
        this.releaseSemaphore = releaseSemaphore;
    }

    @Override
    public void run() {
        try {
            aquireSemaphore.acquire();
            System.out.println("Starte Berechnung für " + this.getName() + ": "
                    + operand + " * " + thread_d.getResult());
            // simulate workload (1-3 sec)
            Thread.sleep((long) (Math.random() * 2000 + 1000));;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        result = thread_d.getResult() * operand;
        releaseSemaphore.release();
        System.out.println(getName() + " berechnet: " + result);
    }

    public int getResult() {
        return result;
    }
}
