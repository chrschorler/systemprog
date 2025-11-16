package Part3;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("---- A1.3: Schutz mit Semaphore ----\n");

        Hilfszahl hilfszahl = new Hilfszahl();
        Semaphore semaphore = new Semaphore(1);

        ThreadImpl thread1 = new ThreadImpl(hilfszahl, "Thread 1", semaphore);
        ThreadImpl thread2 = new ThreadImpl(hilfszahl, "Thread 2", semaphore);
        ThreadImpl thread3 = new ThreadImpl(hilfszahl, "Thread 3", semaphore);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("\nEndwert: " + hilfszahl.getZaehlerWert());
        System.out.println("Erwartet: 3");
        System.out.println("--> Semaphore regelt Zugriff auf kritische Region");
    }
}