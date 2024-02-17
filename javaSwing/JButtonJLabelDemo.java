package javaSwing;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class JButtonJLabelDemo extends JFrame {
    JLabel label;
    JButton button;
    int count = 0;

    public JButtonJLabelDemo() {
        super("JButton JLabel Demo.");
        label = new JLabel("Clicked " + count + " Times");
        button = new JButton("Click");
        label.setToolTipText("Counter"); // the hovered thing popping up on any os.

        add(label);
        add(button);
        button.addActionListener((ActionEvent e) -> {
            count++;
            label.setText("Clicked " + count + " Times");
        });
        
        // to set the icon of the button if needed.
        // button.setIcon(new ImageIcon("C:/Users/vasud/OneDrive/Pictures/IMG_20230704_101951.jpg"));

        this.getRootPane().setDefaultButton(button); //For making the button as default for the complete root panel.

        this.setLayout(new FlowLayout()); // the java swing uses some components of the java awt.
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to close the window and to stop the program.
    }

    public static void main(String[] args) {
        JButtonJLabelDemo f = new JButtonJLabelDemo();
        f.setVisible(true);
    }
}