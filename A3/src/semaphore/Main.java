package semaphore;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore s1 = new Semaphore(0); // d -> g, h
        Semaphore s2 = new Semaphore(0); // g, h -> i
        Semaphore s3 = new Semaphore(0); // a, i -> v
        Semaphore s4 = new Semaphore(0); // y, z -> u

        Thread_ayz a = new Thread_ayz("a", 2, 25, 2, s3);
        Thread_ayz y = new Thread_ayz("y", 8, 5, 3, s4);
        Thread_ayz z = new Thread_ayz("z", 2, 5, s4);

        Thread_d d = new Thread_d("d", 2, 2, s1);

        Thread_gh g = new Thread_gh("g", d, 3, s1, s2);
        Thread_gh h = new Thread_gh("h", d, 5, s1, s2);

        Thread_i i = new Thread_i("i", g, h, s2, s3);

        Thread_u u = new Thread_u("u", y, z, s4);
        Thread_v v = new Thread_v("v", a, i, s3);

        Thread[] threads = {a, y, z, d, g, h, i, v, u};
        for (Thread t : threads) t.start();

        try {
            v.join();
            u.join();
            System.out.println("Starte Berechnung für c: " + v.getResult() + " / " + u.getResult());
            int c = v.getResult() / u.getResult();
            System.out.println("Ergebnis für c: " + c);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
