package join;

public class MultiplyThread extends Thread {

    private int operand1;
    private int operand2;
    private int operand3 = 1;
    private int result;

    public MultiplyThread(String name, int operand1, int operand2) {
        super(name);
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public MultiplyThread(String name, int operand1, int operand2,
                          int operand3) {
        super(name);
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operand3 = operand3;
    }

    @Override
    public void run() {
        System.out.println("Starte Berechnung für " + this.getName() + ": "
                + operand1 + " * " + operand2 + (operand3 == 1 ? "" : " * " + operand3));
        try {
            // simulate workload (1-3 sec)
            Thread.sleep((long) (Math.random() * 2000 + 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        result = operand1 * operand2 * operand3;
        System.out.println(this.getName() + " berechnet: " + result);
    }

    public int getResult() {
        return result;
    }
}
