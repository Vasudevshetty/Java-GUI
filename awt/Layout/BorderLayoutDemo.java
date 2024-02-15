package Layout;

import java.awt.*;

// by Default the layou tis Border layout

public class BorderLayoutDemo extends Frame {
    Button b1, b2, b3, b4, b5, b6;

    public BorderLayoutDemo() {
        super("Flow layout demo.");

        b1 = new Button("One");
        b2 = new Button("Two");
        b3 = new Button("Three");
        b4 = new Button("Four");
        b5 = new Button("Five");
        b6 = new Button("Six");

        this.add(b1, BorderLayout.NORTH);
        // this.add(b2, BorderLayout.SOUTH);
        this.add(b3, BorderLayout.SOUTH);
        this.add(b4, BorderLayout.WEST);
        this.add(b5, BorderLayout.CENTER);

        // add panel to it.
        Panel p = new Panel();
        p.add(new Button("Monday"));
        p.add(new Button("Tuesday"));
        p.add(new Button("Wednesday"));

        p.setLayout(new GridLayout(3, 1));

        this.add(p, BorderLayout.EAST);

        this.setSize(400, 400);
    }

    public static void main(String[] args) {
        BorderLayoutDemo f = new BorderLayoutDemo();
        f.setVisible(true);
    }
}
