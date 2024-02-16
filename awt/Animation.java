import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class Animation extends Frame implements Runnable {
    int x, y, tx, ty; // translation.

    public Animation() {
        this.setSize(550, 450);
        x = y = 100;
        tx = ty = 1;
        Thread t = new Thread(this);
        t.start();
    }

    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x, y, 50, 50);
    }

    public void run() {
        while (true) {

            x += tx;
            y += ty;

            tx *= x < 0 || x > 500 ? -1 : 1;
            ty *= y < 0 || y > 400 ? -1 : 1;
            repaint();
            try {
                Thread.sleep(5);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        Animation a = new Animation();
        a.setVisible(true);
    }
}
