import java.awt.*;
import java.awt.event.*;

/* 
 * This is a 3 scrollbar containing mainpulater which crates a colour of the correspoding value of red, greem and blue
 *  in the 3 scrollbar (0-255).
 */

public class ScrollBarDemo extends Frame implements AdjustmentListener {
    Scrollbar red, blue, green;
    TextField t;

    public ScrollBarDemo() {
        super("Scrollbar demo");
        t = new TextField(30);
        red = new Scrollbar(Scrollbar.HORIZONTAL, 0, 20, 0, 255);
        blue = new Scrollbar(Scrollbar.HORIZONTAL, 0, 20, 0, 255);
        green = new Scrollbar(Scrollbar.HORIZONTAL, 0, 20, 0, 255);

        t.setBounds(50, 50, 300, 50);

        red.setBounds(50, 150, 300, 30);
        green.setBounds(50, 250, 300, 30);
        blue.setBounds(50, 200, 300, 30);

        red.addAdjustmentListener(this);
        green.addAdjustmentListener(this);
        blue.addAdjustmentListener(this);

        this.setLayout(null);
        this.setSize(400, 400);
        this.add(t);
        this.add(red);
        this.add(green);
        this.add(blue);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        t.setBackground(new Color(red.getValue(), green.getValue(), blue.getValue()));
    }

    public static void main(String[] args) {
        ScrollBarDemo s = new ScrollBarDemo();
        s.setVisible(true);
    }
}
