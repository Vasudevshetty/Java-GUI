import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class Animation extends Frame implements Runnable {
    int x1, y1, tx1, ty1; // translation.
    int x2, y2, tx2, ty2; // translation.

    public Animation() {
        this.setSize(550, 450);
        x1 = y1 = 100;
        tx1 = ty1 = 1;
        x2 = y2 = 200;
        tx2 = ty2 = -1;
        Thread t1 = new Thread(this);
        t1.start();
    }

    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x1, y1, 50, 50);
        g.setColor(Color.red);
        g.fillOval(x2, y2, 50, 50);
    }

    public void run() {
        while (true) {
            synchronized (this) {

                x1 += tx1;
                y1 += ty1;

                tx1 *= x1 < 0 || x1 > 500 ? -1 : 1;
                ty1 *= y1 < 0 || y1 > 400 ? -1 : 1;

                x2 += tx2;
                y2 += ty2;

                tx2 *= x2 < 0 || x2 > 500 ? -1 : 1;
                ty2 *= y2 < 0 || y2 > 400 ? -1 : 1;

                repaint();
            }
            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Animation a = new Animation();
        a.setVisible(true);
    }
}
