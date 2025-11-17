package join;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        double d, x, g, b, a, y, h, z, i, u, v, c;

        // P1
        MultiplyThread t_d = new MultiplyThread(2, 2);  // d=2*2
        MultiplyThread t_x = new MultiplyThread(2, 25); // x=2*25
        MultiplyThread t_b = new MultiplyThread(8, 5);  // b=8*5
        MultiplyThread t_z = new MultiplyThread(2,5);   // z=2*5

        t_d.start();
        t_x.start();
        t_b.start();
        t_z.start();

        t_d.join();
        t_x.join();
        t_b.join();

        d = t_d.getResult();
        x = t_x.getResult();
        b = t_b.getResult();

        // P2 - requires d, x, b
        MultiplyThread t_g = new MultiplyThread(d, 3); // g=d*3
        MultiplyThread t_a = new MultiplyThread(x, 2); // a=x*2
        MultiplyThread t_y = new MultiplyThread(b, 3); // y=b*3
        MultiplyThread t_h = new MultiplyThread(d, 5); // h=d*5

        t_g.start();
        t_a.start();
        t_y.start();
        t_h.start();

        t_g.join();
        t_y.join();
        t_h.join();
        t_z.join();

        g = t_g.getResult();
        y = t_y.getResult();
        h = t_h.getResult();
        z = t_z.getResult();

        // P3 - requires g, y, h, z
        MultiplyThread t_i = new MultiplyThread(g,h);   // i=g*h
        MultiplyThread t_u = new MultiplyThread(y,z);   // u=y*z

        t_i.start();
        t_u.start();

        t_i.join();
        t_a.join();

        i = t_i.getResult();
        a = t_a.getResult();

        // P4 - requires i, a
        MultiplyThread t_v = new MultiplyThread(a,i);   // v=a*i

        t_v.start();

        t_v.join();
        t_u.join();

        v = t_v.getResult();
        u = t_u.getResult();

        // P5 - requires v, u
        c = v / u;
        System.out.println("Final Result: " + c);
    }
}
