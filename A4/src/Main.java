public class Main {

    public static void testfall1() {
        System.out.println("\nTESTFALL 1:\n");
        Monitor monitor = new Monitor();
        Datenbank db = new Datenbank(5, 0);
        for(int i = 0; i < 8; i++) new AnfrageThread(monitor, db, 0).start();
        db.printStatus();
    }

    public static void testfall2() {
        System.out.println("\nTESTFALL 2: \n");
        Monitor monitor = new Monitor();
        Datenbank db = new Datenbank(5, 0);
        for (int i = 0; i < 5; i++) new EingangThread(monitor, db, i, 1).start();
        db.printStatus();
    }

    public static void testfall3() {
        System.out.println("\nTESTFALL 3:\n");
        Monitor monitor = new Monitor();
        Datenbank db = new Datenbank(5, 3);
        for(int i = 0; i < 4; i++) new AusgangThread(monitor, db, 0, 1).start();
        db.printStatus();
    }

    public static void testfall4() {
        System.out.println("\nTESTFALL 4:\n");
        Monitor monitor = new Monitor();
        Datenbank db = new Datenbank(5, 2);
        for (int i = 0; i < 4; i++) new EingangThread(monitor, db, i, 2).start();
        for (int i = 0; i < 5; i++) new AnfrageThread(monitor, db, i).start();
        for (int i = 0; i < 4; i++) new AusgangThread(monitor, db, i, 2).start();
        db.printStatus();
    }

    public static void testfall5()  {
        System.out.println("\nTESTFALL 5:\n");
        Monitor monitor = new Monitor();
        Datenbank db = new Datenbank(5, 3);
        // mehrere gleichzeitige Eingänge, Anfragen und Ausgänge auf denselben Artikel
        for (int i = 0; i < 3; i++) new EingangThread(monitor, db, 0, 1).start();
        for (int i = 0; i < 5; i++) new AnfrageThread(monitor, db, 0).start();
        for (int i = 0; i < 3; i++) new AusgangThread(monitor, db, 0, 5).start();
        // zeitversetzt neue Threads
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new AnfrageThread(monitor, db, 0).start();
        new EingangThread(monitor, db, 0, 5).start();
        new AusgangThread(monitor, db, 0, 5).start();
    }

    public static void main(String[] args)  {
        testfall5();
    }

}