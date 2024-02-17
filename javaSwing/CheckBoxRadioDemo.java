package javaSwing;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class CheckBoxRadioDemo extends JFrame {
    JTextField text;
    JCheckBox c1, c2;
    JRadioButton r1, r2;
    ButtonGroup rgp;

    public CheckBoxRadioDemo() {
        super("CheckBox Radio Button Demo");

        text = new JTextField("Demo Text", 15);
        text.setEditable(false);
        text.setBounds(10, 20, 100, 80);

        c1 = new JCheckBox("Bold");
        c1.setMnemonic(KeyEvent.VK_B);
        c1.addActionListener((ActionEvent e) -> {
            manipulateFont();
        });

        c2 = new JCheckBox("Italic");
        c2.setMnemonic(KeyEvent.VK_I);
        c2.addActionListener((ActionEvent e) -> {
            manipulateFont();
        });

        r1 = new JRadioButton("Lower");
        r1.addActionListener((ActionEvent e) -> {
            performTask(e.getActionCommand());
        });

        r2 = new JRadioButton("Upper");
        r2.addActionListener((ActionEvent e) -> {
            performTask(e.getActionCommand());
        });

        rgp = new ButtonGroup();
        rgp.add(r1);
        rgp.add(r2);

        this.add(text);
        this.add(c1);
        this.add(c2);
        this.add(r1);
        this.add(r2);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
    }

    private void performTask(String action) {
        switch (action) {
            case "Lower":
                text.setText(text.getText().toLowerCase());
                break;
            case "Upper":
                text.setText(text.getText().toUpperCase());
        }
    }

    private void manipulateFont() {
        int b = 0, i = 0;
        if (c1.isSelected())
            b = Font.BOLD;
        if (c2.isSelected())
            i = Font.ITALIC;
        Font f = new Font("Times New Roman", b | i, 15);
        text.setFont(f);
    }

    public static void main(String[] args) {
        CheckBoxRadioDemo c = new CheckBoxRadioDemo();
        c.setVisible(true);
    }
}
