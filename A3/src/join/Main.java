package join;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        int d, g, a, y, h, z, i, u, v, c;

        MultiplyThread thread_d = new MultiplyThread("d", 2, 2);  // d=2*2
        MultiplyThread thread_a = new MultiplyThread("a", 2, 25, 2); // a=2*25*2
        MultiplyThread thread_y = new MultiplyThread("y", 8, 5, 3);  // y=8*5*3
        MultiplyThread thread_z = new MultiplyThread("z", 2, 5);   // z=2*5

        thread_d.start();
        thread_a.start();
        thread_y.start();
        thread_z.start();

        thread_d.join();

        d = thread_d.getResult();

        MultiplyThread thread_g = new MultiplyThread("g", d, 3);
        MultiplyThread thread_h = new MultiplyThread("h", d, 5);

        thread_g.start();
        thread_h.start();

        thread_y.join();
        thread_z.join();

        z = thread_z.getResult();
        y = thread_y.getResult();

        MultiplyThread thread_u = new MultiplyThread("u", y, z);
        thread_u.start();

        thread_g.join();
        thread_h.join();

        g = thread_g.getResult();
        h = thread_h.getResult();

        MultiplyThread thread_i = new MultiplyThread("i", g, h);
        thread_i.start();

        thread_a.join();
        thread_i.join();

        i = thread_i.getResult();
        a = thread_a.getResult();

        MultiplyThread thread_v = new MultiplyThread("v", a, i);
        thread_v.start();

        thread_v.join();
        thread_u.join();

        v = thread_v.getResult();
        u = thread_u.getResult();

        System.out.println("Starte Berechnung für c: " + v + " / " + u);
        c = v / u;
        System.out.println("Ergebnis für c: " + c);
    }
}
