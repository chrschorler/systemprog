package Part4;

public class ThreadImpl extends Thread {

    private Hilfszahl hilfszahl;

    public ThreadImpl(Hilfszahl hilfszahl, String name) {
        super(name);
        this.hilfszahl = hilfszahl;
    }

    @Override
    public void run() {
        // Aufruf der synchronized Methode --> kritische Region geschützt
        hilfszahl.erhoeheUmEins(this.getName());
    }
}
