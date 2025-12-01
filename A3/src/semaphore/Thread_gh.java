package semaphore;

import java.util.concurrent.Semaphore;

public class Thread_gh extends BaseThread {

    private int operand;
    private BaseThread thread;
    private Semaphore aquireSemaphore;
    private Semaphore releaseSemaphore;

    public Thread_gh(String name, BaseThread thread, int operand,
                     Semaphore aquireSemaphore, Semaphore releaseSemaphore) {
        super(name);
        this.operand = operand;
        this.thread = thread;
        this.aquireSemaphore = aquireSemaphore;
        this.releaseSemaphore = releaseSemaphore;
    }

    @Override
    public void run() {
        try {
            aquireSemaphore.acquire();
            System.out.println("Starte Berechnung für " + this.getName());
            Thread.sleep((long)(Math.random() * 5000));
            result = thread.getResult() * operand;
            releaseSemaphore.release();
            System.out.println(getName() + " berechnet: " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
