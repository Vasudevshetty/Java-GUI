import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaintingDemo extends Frame {
    int x = 0, y = 0;

    public PaintingDemo() {
        super("Painting Demo");
        this.setSize(400, 400);
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                x = e.getY();
                y = e.getX();
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        // explore methods.
        g.setColor(Color.red);
        g.setFont(new Font("NoteWorthy", Font.BOLD, 30));
        g.drawString("Hello", x, y);
        g.drawOval(x, y, 50, 50);
        g.fillOval(y, x, 50, 50);
    }

    public static void main(String[] args) {
        PaintingDemo p = new PaintingDemo();
        p.setVisible(true);
    }
}
