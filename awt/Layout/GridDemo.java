package Layout;

import java.awt.*;

public class GridDemo extends Frame {
    Button b1, b2, b3, b4, b5, b6;

    public GridDemo() {
        super("Flow layout demo.");

        b1 = new Button("One");
        b2 = new Button("Two");
        b3 = new Button("Three");
        b4 = new Button("Four");
        b5 = new Button("Five");
        b6 = new Button("Six");

        // grid layout is just to mention the rows and coloumns.
        // this.setLayout(new GridLayout(3, 2));

        GridBagLayout g = new GridBagLayout();
        this.setLayout(g);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 1;
        gbc.gridy = 1;

        this.add(b1, gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        this.add(b2, gbc);
        gbc.gridx = 3;
        gbc.gridy = 3;
        this.add(b3, gbc);
        gbc.gridx = 4;
        gbc.gridy = 4;
        this.add(b4, gbc);
        gbc.gridx = 5;
        gbc.gridy = 5;
        this.add(b5, gbc);
        gbc.gridx = 6;
        gbc.gridy = 6;
        this.add(b6, gbc);

        this.setSize(400, 400);
    }

    public static void main(String[] args) {
        GridDemo f = new GridDemo();
        f.setVisible(true);
    }
}
