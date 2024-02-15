package Layout;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CardDemo extends Frame implements ItemListener {
    Button b1, b2, b3;
    TextField t1, t2, t3;

    Panel p1, p2, mainp, cp;

    Checkbox c1, c2;

    CardLayout cl;

    public CardDemo() {
        super("Card Layout Demo");

        CheckboxGroup cbg = new CheckboxGroup();

        c1 = new Checkbox("One", true, cbg);
        c2 = new Checkbox("Two", false, cbg);

        c1.addItemListener(this);
        c2.addItemListener(this);

        b1 = new Button("One");
        b2 = new Button("Two");
        b3 = new Button("Three");

        t1 = new TextField(10);
        t2 = new TextField(10);
        t3 = new TextField(10);

        cp = new Panel();
        cp.add(c1);
        cp.add(c2);

        p1 = new Panel();
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);

        p2 = new Panel();
        p2.add(t1);
        p2.add(t2);
        p2.add(t3);

        mainp = new Panel();
        cl = new CardLayout();
        mainp.setLayout(cl);

        mainp.add("One", p1);
        mainp.add("Two", p2);

        this.add(cp, BorderLayout.NORTH);
        this.add(mainp, BorderLayout.CENTER);
        this.setSize(400, 400);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (c1.getState())
            cl.first(mainp);
        else
            cl.last(mainp);
    }

    public static void main(String[] args) {
        CardDemo c = new CardDemo();
        c.setVisible(true);
    }
}