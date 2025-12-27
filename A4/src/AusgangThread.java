class AusgangThread extends Thread {
    private Monitor monitor;
    private Datenbank db;
    private int artikelNr, menge;

    public AusgangThread(Monitor m, Datenbank d, int nr, int mng) {
        this.monitor = m;
        this.db = d;
        this.artikelNr = nr;
        this.menge = mng;
    }

    public void run() {
        try {
            monitor.ausgangAnfang();
            Thread.sleep(100);
            db.entnehmen(artikelNr, menge);
            monitor.ausgangEnde();
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}