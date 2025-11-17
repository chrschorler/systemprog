package join;

public class MultiplyThread extends Thread {

    private double operand1;
    private double operand2;
    private double operand3 = 1.0;
    private double result;

    public MultiplyThread(double operand1, double operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public MultiplyThread(double operand1, double operand2, double operand3) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operand3 = operand3;
    }

    @Override
    public void run() {
        result = operand1 * operand2 * operand3;
    }

    public double getResult() {
        return result;
    }
}
