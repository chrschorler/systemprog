package c;

public class Semaphore {
    private int value;

    public Semaphore(int initialValue) {
        if (initialValue < 0) value = 0;
        else value = initialValue;
    }

    public void p() {
        p(1);
    }

    public synchronized void p(int x) {
        if (x <= 0) return;
        while (value - x < 0) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        value -= x;
    }

    public void v() {
        v(1);
    }

    public synchronized void v(int x) {
        if (x <= 0) return;
        value += x;
        notifyAll();
    }
}
