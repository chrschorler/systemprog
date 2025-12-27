import java.util.concurrent.Semaphore;

public class Monitor {

    private final Semaphore iws1;
    private final Semaphore iws2;

    private final Semaphore ausgangWartenSem;
    private final Semaphore eingangWartenSem;
    private final Semaphore anfrageWartenSem;

    public int iws2Wartend = 0;

    public int ausgangWartend;
    public int eingangWartend;
    public int anfrageWartend;

    public int ausgangAktiv;
    public int eingangAktiv;
    public int anfrageAktiv;

    public Monitor() {
        this.iws1 = new Semaphore(1);
        this.iws2 = new Semaphore(0);
        this.ausgangWartenSem = new Semaphore(0);
        this.eingangWartenSem = new Semaphore(0);
        this.anfrageWartenSem = new Semaphore(0);
    }

    private void betreteMonitor()  {
        try {
            iws1.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void belegeMonitor() {
        String status = String.format(
                "Aktiv:   Ausgänge: %d | Eingänge: %d | Anfragen: %d\n" +
                "Wartend: Ausgänge: %d | Eingänge: %d | Anfragen: %d\n" +
                "------------------------------------------------",
                ausgangAktiv, eingangAktiv, anfrageAktiv,
                ausgangWartend, eingangWartend, anfrageWartend
        );
        System.out.println(status);
        if (iws2Wartend > 0) {
            iws2Wartend--;
            iws2.release();
        } else {
            iws1.release();
        }
    }

    public void anfrageAnfang() throws InterruptedException {
        betreteMonitor();
        // Wartet, wenn ein Ausgang/Eingang aktiv ist, Limit von 5 erreicht ist oder höhere Prio wartet
        if (ausgangAktiv > 0 || eingangAktiv > 0 || anfrageAktiv == 5 || ausgangWartend > 0) {
            anfrageWartend++;
            belegeMonitor();
            anfrageWartenSem.acquire();
            iws2.acquire();
        }
        anfrageAktiv++;
        belegeMonitor();
    }

    public void anfrageEnde() {
        betreteMonitor();
        anfrageAktiv--;
        if (anfrageAktiv == 0) {
            if (ausgangWartend > 0) {
                ausgangWartend--;
                ausgangWartenSem.release();
                iws2Wartend++;
            } else if (eingangWartend > 0) {
                int zuWecken = eingangWartend;
                if (zuWecken > 3) zuWecken = 3;
                for (int i = 0; i < zuWecken; i++) {
                    eingangWartend--;
                    eingangWartenSem.release();
                    iws2Wartend++;
                }
            }
        } else if (anfrageWartend > 0 && ausgangWartend == 0) {
            anfrageWartend--;
            anfrageWartenSem.release();
            iws2Wartend++;
        }
        belegeMonitor();
    }

    public void ausgangAnfang() throws InterruptedException {
        betreteMonitor();
        // Wartet wenn ein anderer Thread aktiv ist, um exklusiven Zugriff zu garantieren
        if (ausgangAktiv > 0 || eingangAktiv > 0 || anfrageAktiv > 0) {
            ausgangWartend++;
            belegeMonitor();
            ausgangWartenSem.acquire();
            iws2.acquire();
        }
        ausgangAktiv++;
        belegeMonitor();
    }

    public void ausgangEnde() {
        betreteMonitor();
        ausgangAktiv--;
        if (ausgangWartend > 0) {
            ausgangWartend--;
            ausgangWartenSem.release();
            iws2Wartend++;
        } else if (anfrageWartend > 0) {
            int zuWecken = anfrageWartend;
            if (zuWecken > 5) zuWecken = 5;
            for (int i = 0; i < zuWecken; i++) {
                anfrageWartend--;
                anfrageWartenSem.release();
                iws2Wartend++;
            }
        } else if (eingangWartend > 0) {
            int zuWecken = eingangWartend;
            if (zuWecken > 3) zuWecken = 3;
            for (int i = 0; i < zuWecken; i++) {
                eingangWartend--;
                eingangWartenSem.release();
                iws2Wartend++;
            }
        }
        belegeMonitor();
    }

    public void eingangAnfang() throws InterruptedException {
        betreteMonitor();
        // Wartet wenn Ausgang/Anfrage aktiv ist, Limit von 3 erreicht ist oder höhere Prio wartet
        if (ausgangAktiv > 0 || anfrageAktiv > 0 || eingangAktiv == 3 || ausgangWartend > 0 || anfrageWartend > 0) {
            eingangWartend++;
            belegeMonitor();
            eingangWartenSem.acquire();
            iws2.acquire();
        }
        eingangAktiv++;
        belegeMonitor();
    }

    public void eingangEnde() {
        betreteMonitor();
        eingangAktiv--;
        if (eingangAktiv == 0) {
            if (ausgangWartend > 0) {
                ausgangWartend--;
                ausgangWartenSem.release();
                iws2Wartend++;
            } else if (anfrageWartend > 0) {
                int zuWecken = anfrageWartend;
                if (zuWecken > 5) zuWecken = 5;
                for (int i = 0; i < zuWecken; i++) {
                    anfrageWartend--;
                    anfrageWartenSem.release();
                    iws2Wartend++;
                }
            } else if (eingangWartend > 0) {
                int zuWecken = eingangWartend;
                if (zuWecken > 3) zuWecken = 3;
                for (int i = 0; i < zuWecken; i++) {
                    eingangWartend--;
                    eingangWartenSem.release();
                    iws2Wartend++;
                }
            }
        } else {
            if (eingangWartend > 0 && ausgangWartend == 0 && anfrageWartend == 0) {
                eingangWartend--;
                eingangWartenSem.release();
                iws2Wartend++;
            }
        }
        belegeMonitor();
    }
}
