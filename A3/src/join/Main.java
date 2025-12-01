package join;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        double d, x, g, b, a, y, h, z, i, u, v, c;

        // P1
        MultiplyThread t_d = new MultiplyThread("d", 2, 2);  // d=2*2
        MultiplyThread t_a = new MultiplyThread("a", 2, 25, 2); // a=2*25*2
        MultiplyThread t_y = new MultiplyThread("y", 8, 5, 3);  // y=8*5*3
        MultiplyThread t_z = new MultiplyThread("z", 2, 5);   // z=2*5

        t_d.start();
        t_a.start();
        t_y.start();
        t_z.start();

        t_d.join();

        d = t_d.getResult();

        MultiplyThread t_g = new MultiplyThread("g", d, 3);
        MultiplyThread t_h = new MultiplyThread("h", d, 5);

        t_g.start();
        t_h.start();

        t_g.join();
        t_h.join();

        g = t_g.getResult();
        h = t_h.getResult();

        MultiplyThread t_i = new MultiplyThread("i", g, h);

        t_i.start();

        t_a.join();
        t_i.join();

        i = t_i.getResult();
        a = t_a.getResult();

        t_y.join();
        t_z.join();

        z = t_z.getResult();
        y = t_y.getResult();

        MultiplyThread t_u = new MultiplyThread("u", y, z);
        MultiplyThread t_v = new MultiplyThread("v", a, i);

        t_v.start();
        t_u.start();

        t_v.join();
        t_u.join();
        v = t_v.getResult();
        u = t_u.getResult();

        c = v / u;
        System.out.println("Final Result: " + c);
    }
}
