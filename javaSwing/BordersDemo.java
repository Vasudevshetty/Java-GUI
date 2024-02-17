package javaSwing;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class BordersDemo extends JFrame {
    JLabel label;
    JTextField text;
    JButton click;
    JPanel panel;

    public BordersDemo() {
        super("Boder Demo");

        label = new JLabel("Name");
        text = new JTextField(20);
        click = new JButton("Click");
        panel = new JPanel();
        panel.add(label);
        panel.add(text);
        panel.add(click);

        Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red, 4), "Login",
                TitledBorder.CENTER, TitledBorder.LEFT);
        panel.setBorder(border);

        this.add(panel);
        this.setLayout(new FlowLayout());
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BordersDemo b = new BordersDemo();
        b.setVisible(true);
    }
}
