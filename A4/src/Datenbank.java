public class Datenbank {

    private int[] bestand;

    public Datenbank(int anzahlArtikel, int initialBestand) {
        bestand = new int[anzahlArtikel];
        for (int i = 0; i < anzahlArtikel; i++) {
            bestand[i] = initialBestand;
        }
    }

    public void abfragen(int artikelNr) {
        System.out.println("Datenbank-Anfrage: A" + (artikelNr + 1) + " hat Bestand: " + bestand[artikelNr]);
        printStatus();
    }

    public void hinzufuegen(int artikelNr, int menge) {
        bestand[artikelNr] += menge;
        System.out.println("Datenbank-Eingang: A" + (artikelNr + 1) + "()" + " + " + menge);
        printStatus();
    }

    public void entnehmen(int artikelNr, int menge) {
        int aktuellerBestand = bestand[artikelNr];
        if (aktuellerBestand <= 0) {
            System.err.println("WARNUNG: Ausgang von A" + (artikelNr + 1) + " unmöglich (Bestand ist 0).");
        }
        else if (menge > aktuellerBestand) {
            System.err.println("WARNUNG: Nicht ausreichend Bestand für A" + (artikelNr + 1) +
                    "! Verlangt: " + menge + ", Vorhanden: " + aktuellerBestand);

            bestand[artikelNr] = 0;
            System.out.println("Datenbank-Ausgang: A" + (artikelNr + 1) + " - " + aktuellerBestand);
        }
        else {
            bestand[artikelNr] -= menge;
            System.out.println("Datenbank-Ausgang: A" + (artikelNr + 1) + " - " + menge);
        }
        printStatus();
    }

    public void printStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("Datenbank: ");
        for (int i = 0; i < bestand.length; i++) {
            sb.append("A").append(i + 1).append(": ").append(bestand[i]).append(" ");
        }
        System.out.println(sb);
        System.out.println("----------------------------------------");
    }
}