package javaSwing;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JTextDemo extends JFrame {
    public JTextDemo() {
        super("TextField/Area/FormatedFeild Demo.");

        JLabel label = new JLabel("");
        JTextField textField = new JTextField(15);

        textField.addActionListener((ActionEvent e) -> {
            label.setText(textField.getText());
        });

        DateFormat date = new SimpleDateFormat("dd/MMMM/yyyy");
        JFormattedTextField ftext = new JFormattedTextField(date);
        ftext.setColumns(15);
        ftext.setValue(new Date());

        this.add(ftext);
        this.add(textField);
        this.add(label);

        NumberFormat num = NumberFormat.getNumberInstance();
        NumberFormatter nft = new NumberFormatter(num);
        nft.setAllowsInvalid(false);
        nft.setMaximum(1000);

        JFormattedTextField ntext = new JFormattedTextField(nft);
        ntext.setColumns(15);
        ntext.setValue(0);

        this.add(ntext);

        JTextArea tArea = new JTextArea(30, 30);
        // same as awt all the methods are there explore.
        this.add(tArea);

        this.setLayout(new FlowLayout());
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JTextDemo j = new JTextDemo();
        j.setVisible(true);
    }
}
