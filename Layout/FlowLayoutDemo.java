package Layout;

import java.awt.*;

public class FlowLayoutDemo extends Frame {
    Button b1, b2, b3, b4, b5, b6;

    public FlowLayoutDemo() {
        super("Flow layout demo.");

        b1 = new Button("One");
        b2 = new Button("Two");
        b3 = new Button("Three");
        b4 = new Button("Four");
        b5 = new Button("Five");
        b6 = new Button("Six");

        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.RIGHT);
        fl.setHgap(100);
        fl.setVgap(50);

        this.setLayout(fl);

        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
        this.add(b6);

        this.setSize(400, 400);
    }

    public static void main(String[] args) {
        FlowLayoutDemo f = new FlowLayoutDemo();
        f.setVisible(true);
    }
}
