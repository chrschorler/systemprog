package Part1;

public class ThreadImpl extends Thread {

    private Hilfszahl hilfszahl;

    public ThreadImpl(Hilfszahl hilfszahl, String name) {
        super(name);
        this.hilfszahl = hilfszahl;
    }

    @Override
    public void run() {
        // Kritische Region ist ungeschützt
        int alterWert = hilfszahl.getZaehlerWert();
        System.out.println(this.getName() + " liest Wert: " + alterWert);

        int neuerWert = alterWert + 1;

        // Sleep erzwingt parallele Ausführung
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        hilfszahl.setZaehlerWert(neuerWert);
        System.out.println(this.getName() + " schreibt Wert: " + neuerWert);
    }
}
