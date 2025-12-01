package join;

public class MultiplyThread extends Thread {

    private double operand1;
    private double operand2;
    private double operand3 = 1.0;
    private double result;

    public MultiplyThread(String name, double operand1, double operand2) {
        super(name);
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public MultiplyThread(String name, double operand1, double operand2, double operand3) {
        super(name);
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operand3 = operand3;
    }

    @Override
    public void run() {
        // simulate workload
        System.out.println("Thread " + getName() + " gestartet.");

        try {
            Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        result = operand1 * operand2 * operand3;
        System.out.println("Thread " + this.getName() + " fertig. Ergebnis: " + (int)result);
    }

    public double getResult() {
        return result;
    }
}
