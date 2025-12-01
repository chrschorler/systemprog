package semaphore;

abstract class BaseThread extends Thread {

    protected int result;
    public BaseThread(String name) { super(name); }
    public int getResult() { return result; }
}