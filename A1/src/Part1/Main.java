package Part1;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("---- A1.1: Indeterminiertes Verhalten ----\n");

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
        System.out.println("--> Alle Threads lesen gleichzeitig 0 und schreiben 1");
    }
}
