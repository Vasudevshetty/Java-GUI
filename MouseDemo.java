import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseDemo extends Frame implements MouseListener, MouseMotionListener {
    Label l,l2;

    MouseDemo() {
        l = new Label();
        l2 = new Label();
        setLayout(null);

        l.setBounds(20, 50, 100, 20);
        l2.setBounds(20, 100, 100, 20);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        add(l);
        add(l2);
        this.setSize(400, 400);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        l.setText("Mouse clicked");
    }


    @Override
    public void mousePressed(MouseEvent e) {
        l.setText("Mouse presesed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        l.setText("Mouse Relaseed");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        l.setText("Mouse entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        l.setText("Mouse exited");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        l.setText("Mouse dragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        l.setText("Mouse moved");
        l2.setText("(" + e.getX() + ", " + e.getY() + ")");
    }

    public static void main(String[] args) {
        MouseDemo m = new MouseDemo();
        m.setVisible(true);
    }
}
