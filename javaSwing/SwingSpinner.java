package javaSwing;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;

public class SwingSpinner extends JFrame {
    JComboBox<String> box;
    JList<String> list;
    JSpinner spin1, spin2;
    JTextField text;

    public SwingSpinner() {
        super("Spinner demo");

        String countries[] = { "India", "UK", "US", "Canada", "Australia" };
        String months[] = { "Januaury", "Febrauary", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };
        String days[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

        box = new JComboBox<>(countries);
        list = new JList<>(months);
        list.setVisibleRowCount(5);
        text = new JTextField(15);

        spin1 = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        spin2 = new JSpinner(new SpinnerListModel(days));

        box.addActionListener((ActionEvent e) -> {
            text.setText(String.valueOf(box.getSelectedItem()));
        });

        list.addListSelectionListener((ListSelectionEvent e) -> {
            text.setText(list.getSelectedValue());
        });

        spin1.addChangeListener((ChangeEvent e) -> {
            text.setText(spin1.getValue() + "");
        });

        spin2.addChangeListener((ChangeEvent e) -> {
            text.setText(spin2.getValue() + "");
        });

        this.setLayout(new FlowLayout());
        this.add(box);
        this.add(spin1);
        this.add(spin2);
        this.add(new JScrollPane(list));
        this.add(text);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
    }

    public static void main(String[] args) {
        SwingSpinner s = new SwingSpinner();
        s.setVisible(true);
    }
}
