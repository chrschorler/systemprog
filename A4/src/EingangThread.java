class EingangThread extends Thread {
    private Monitor monitor;
    private Datenbank db;
    private int artikelNr, menge;

    public EingangThread(Monitor m, Datenbank d, int nr, int mng) {
        this.monitor = m;
        this.db = d;
        this.artikelNr = nr;
        this.menge = mng;
    }

    public void run() {
        try {
            monitor.eingangAnfang();
            Thread.sleep(100);
            db.hinzufuegen(artikelNr, menge);
            monitor.eingangEnde();
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}