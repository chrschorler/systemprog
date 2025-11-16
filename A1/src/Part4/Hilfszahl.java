package Part4;

public class Hilfszahl {

    private int zaehlerWert = 0;

    public int getZaehlerWert() {
        return zaehlerWert;
    }

    public void setZaehlerWert(int zaehlerWert) {
        this.zaehlerWert = zaehlerWert;
    }

    public synchronized void erhoeheUmEins(String threadName) {
        int alterWert = this.zaehlerWert;
        System.out.println(threadName + " liest Wert: " + alterWert);

        int neuerWert = alterWert + 1;

        try {
            Thread.sleep(100); // Verzögerung
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.zaehlerWert = neuerWert;
        System.out.println(threadName + " schreibt Wert: " + neuerWert);
    }
}
