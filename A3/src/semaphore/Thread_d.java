package semaphore;

import java.util.concurrent.Semaphore;

public class Thread_d extends Thread {

    private int operand1;
    private int operand2;
    private int result;
    private Semaphore semaphore;

    public Thread_d(String name, int operand1, int operand2, Semaphore semaphore) {
        super(name);
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Starte Berechnung für " + this.getName() + ": " + operand1 + " * " + operand2);
        try {
            // simulate workload (1-3 sec)
            Thread.sleep((long) (Math.random() * 2000 + 1000));;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        result = operand1 * operand2;
        System.out.println(getName() + " berechnet: " + result );
        semaphore.release(2);
    }

    public int getResult() {
        return result;
    }
}
