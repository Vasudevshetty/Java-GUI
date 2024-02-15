import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyListener;
import java.util.Date;
import java.awt.event.KeyEvent;

public class KeyEventDemo extends Frame implements KeyListener {
    Label l1, l2, l3, l4;

    public KeyEventDemo() {
        super("Key event demo");

        l1 = new Label("");
        l2 = new Label("");
        l3 = new Label("");
        l4 = new Label("");

        l1.setBounds(50, 50, 100, 20);
        l2.setBounds(50, 80, 100, 20);
        l3.setBounds(50, 110, 100, 20);
        l4.setBounds(50, 140, 300, 20);

        this.setLayout(null);
        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);

        this.addKeyListener(this);
        this.setSize(400, 400);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        l1.setText("KeyPressed " + e.getKeyChar());
        l2.setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        l3.setText("Key Typed");
        l4.setText(new Date(e.getWhen()) + "");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        l2.setText("Key Relased ");
        l1.setText("");
        l3.setText("");
        l4.setText("");
    }

    public static void main(String[] args) {
        KeyEventDemo k = new KeyEventDemo();
        k.setVisible(true);
    }
}
