package semaphore;

import java.util.concurrent.Semaphore;

public class Thread_vu extends BaseThread {

    private BaseThread thread1;
    private BaseThread thread2;
    private Semaphore aquireSemaphore;

    public Thread_vu(String name, BaseThread thread1, BaseThread thread2,
                     Semaphore aquireSemaphore) {
        super(name);
        this.thread1 = thread1;
        this.thread2 = thread2;
        this.aquireSemaphore = aquireSemaphore;
    }

    @Override
    public void run() {
        try {
            aquireSemaphore.acquire(2);
            System.out.println("Starte Berechnung für " + this.getName());
            Thread.sleep((long)(Math.random() * 5000));
            result = thread1.getResult() * thread2.getResult();
            System.out.println(getName() + " berechnet: " + result );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
