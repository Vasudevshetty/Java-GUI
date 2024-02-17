package javaSwing;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
// import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;

public class SplitPaneTabbedPaneDemo extends JFrame {
    JList<String> list;
    JTabbedPane pane;
    // JSplitPane pane;
    JLabel label;

    public SplitPaneTabbedPaneDemo() {
        super("Split and tabbed pane demo");

        String[] colors = { "RED", "GREEN", "BLUE", "YELLOW", "MAGENTA", "ORANGE", "BLACK" };
        list = new JList<>(colors);
        JScrollPane scroll1 = new JScrollPane(list);

        label = new JLabel("");
        label.setOpaque(true);
        label.setBackground(Color.red);
        JScrollPane scroll2 = new JScrollPane(label);

        // pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll1, scroll2);
        // pane.setDividerLocation(200);

        pane = new JTabbedPane();
        pane.addTab("Colors", scroll1);
        pane.addTab("Label", scroll2);

        list.setSelectedIndex(0);
        list.addListSelectionListener((ListSelectionEvent e) -> {
            String col = (String) list.getSelectedValue();
            switch (col) {
                case "RED":
                    label.setBackground(Color.RED);
                    break;
                case "BLUE":
                    label.setBackground(Color.BLUE);
                    break;
                case "MAGENTA":
                    label.setBackground(Color.MAGENTA);
                    break;
                case "GREEN":
                    label.setBackground(Color.GREEN);
                    break;
                case "YELLOW":
                    label.setBackground(Color.YELLOW);
                    break;
                case "BLACK":
                    label.setBackground(Color.BLACK);
                    break;
                case "ORANGE":
                    label.setBackground(Color.ORANGE);
                    break;
            }
        });
        this.add(pane);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SplitPaneTabbedPaneDemo i = new SplitPaneTabbedPaneDemo();
        i.setVisible(true);
    }
}
