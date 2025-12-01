package semaphore;

import java.util.concurrent.Semaphore;

public class Thread_i extends BaseThread {

    private BaseThread thread1;
    private BaseThread thread2;
    private Semaphore aquireSemaphore;
    private Semaphore releaseSemaphore;

    public Thread_i(String name, BaseThread thread1, BaseThread thread2,
                    Semaphore aquireSemaphore, Semaphore releaseSemaphore) {
        super(name);
        this.thread1 = thread1;
        this.thread2 = thread2;
        this.aquireSemaphore = aquireSemaphore;
        this.releaseSemaphore = releaseSemaphore;
    }

    @Override
    public void run() {
        try {
            aquireSemaphore.acquire(2);
            System.out.println("Starte Berechnung für " + this.getName());
            Thread.sleep((long)(Math.random() * 5000));
            result = thread1.getResult() * thread2.getResult();
            System.out.println(getName() + " berechnet: " + result);
            releaseSemaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
