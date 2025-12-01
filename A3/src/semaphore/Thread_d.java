package semaphore;

import java.util.concurrent.Semaphore;

public class Thread_d extends BaseThread {

    private int operand1;
    private int operand2;
    private Semaphore semaphore;

    public Thread_d(String name, int operand1, int v2, Semaphore semaphore) {
        super(name);
        this.operand1 = operand1; this.operand2 = v2; this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("Starte Berechnung für " + this.getName());
            Thread.sleep((long)(Math.random() * 5000));
            result = operand1 * operand2;
            System.out.println(getName() + " berechnet: " + result);
            semaphore.release(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
