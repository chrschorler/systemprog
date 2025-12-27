class AnfrageThread extends Thread {
    private Monitor monitor;
    private Datenbank db;
    private int artikelNr;

    public AnfrageThread(Monitor m, Datenbank d, int nr) {
        this.monitor = m;
        this.db = d;
        this.artikelNr = nr;
    }

    public void run() {
        try {
            monitor.anfrageAnfang();
            Thread.sleep(100); // Simulation
            db.abfragen(artikelNr);
            monitor.anfrageEnde();
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}