import java.util.concurrent.Semaphore;

public class Monitor {

    Semaphore iws1 = new Semaphore(1);
    Semaphore iws2 = new Semaphore(0);

    public int iws2Wartend = 0;

    Semaphore ausgangWarten = new Semaphore(0);
    Semaphore eingangWarten = new Semaphore(0);
    Semaphore anfrageWarten = new Semaphore(0);

    // Überblick wie viele sind grad am Warten sind aktuellen Stand ausgeben
    // 6 variablen

    public int ausgangWartend = 0;
    public int eingangWartend = 0;
    public int anfrageWartend = 0;

    public int ausgangAktiv = 0;
    public int eingangAktiv = 0;
    public int anfrageAktiv = 0;

    // Jede Methode beginnt damit
    // prüft ob er darf und  verhindert dass anderer rein darf
    private void betreteMonitor() {
        try {
        iws1.acquire();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    // eine Zeile mit den drei variablen wie viel Aktiv sind
    // eine Zeile mit den variablen wie viele wartend sind
    // und das zu begin von belege Monitor
    private void belegeMonitor() {
        if(iws2Wartend > 0) {
            // hat vorrang
            iws2Wartend--;
            iws2.release();
        } else {
            iws1.release();
        }
        // anpassung der variable immer vor release wichtig
    }

    public void anfrageAnfang() throws InterruptedException {
        betreteMonitor();
        if (ausgangAktiv > 0 || eingangAktiv > 0 || anfrageAktiv == 5 || ausgangAktiv > 0) {
            // dann warten weil nur eine davon stattfinden darf?
            anfrageWartend++;
            belegeMonitor();
            anfrageWarten.acquire();
            iws2.acquire();
        }

        ausgangAktiv++;
        belegeMonitor();
    }

    public void anfrageEnde() {
        betreteMonitor();
        anfrageAktiv--;
        if (anfrageAktiv == 0) {
            // andere sachen aus warteschlange holen mit höherer Prio
            if (ausgangWartend > 0) {
                ausgangWartend--;
                ausgangWarten.release();
                iws2Wartend++;
                // die 3 sachen sind wecken -> öfter gebraucht
            } else {
                if (eingangWartend > 0) {
                    int zuWecken = eingangWartend;
                    if (zuWecken > 3 ) zuWecken = 3;
                    for (int i = 0; i < zuWecken; i++) {
                        eingangWartend--;
                        eingangWarten.release();
                        iws2Wartend++;
                    }
                } else {
                    if (anfrageWartend > 0 && ausgangWartend == 0) {
                        // anfrage starten gkeiches Schema

                    }
                }
            }
        }
        belegeMonitor();
    }

    // jetzt selbes für die andren beiden

    // Ausgang ist maximal 1, wenn man 1 abzieht braucht man maximal auf 0 prüfen, folglich nur den oberen Teil
    // wenn ausgang wartet ausgang wecken, wenn anfrage max 5 warten, wenn eingang warten max 3 wecken, das gleich 0 entfällt.


}
