package Part2;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("---- A1.2: Schutz mit synchronized auf Hilfszahl Objekt ----\n");

        Hilfszahl hilfszahl = new Hilfszahl();

        ThreadImpl thread1 = new ThreadImpl(hilfszahl, "Thread 1");
        ThreadImpl thread2 = new ThreadImpl(hilfszahl, "Thread 2");
        ThreadImpl thread3 = new ThreadImpl(hilfszahl, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("\nEndwert: " + hilfszahl.getZaehlerWert());
        System.out.println("Erwartet: 3");
        System.out.println("--> synchronized verhindert gleichzeitigen Zugriff");
    }

}
