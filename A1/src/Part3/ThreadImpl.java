package Part3;

import java.util.concurrent.Semaphore;

public class ThreadImpl extends Thread {

    private Hilfszahl hilfszahl;
    private Semaphore semaphore;

    public ThreadImpl(Hilfszahl hilfszahl, String name, Semaphore semaphore) {
        super(name);
        this.hilfszahl = hilfszahl;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            // Kritische Region geschützt mit Semaphore
            semaphore.acquire();

            int alterWert = hilfszahl.getZaehlerWert();
            System.out.println(this.getName() + " liest Wert: " + alterWert);

            int neuerWert = alterWert + 1;

            // Sleep erzwingt parallele Ausführung
            Thread.sleep(100);

            hilfszahl.setZaehlerWert(neuerWert);
            System.out.println(this.getName() + " schreibt Wert: " + neuerWert);

            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
