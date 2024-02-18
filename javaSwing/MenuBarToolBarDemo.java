package javaSwing;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

public class MenuBarToolBarDemo extends JFrame {
    JToolBar bar;
    JButton[] buttons;
    JTextArea text;

    public MenuBarToolBarDemo() {
        super("Tool bar demo");
        bar = new JToolBar();
        buttons = new JButton[7];

        int buttonSize = 50; // specify the size you want

        buttons[0] = new JButton(new ImageIcon(new ImageIcon("D:/Projects/Java GUI/javaSwing/Resources/open.png")
                .getImage().getScaledInstance(buttonSize, buttonSize, java.awt.Image.SCALE_SMOOTH), "Open"));

        buttons[1] = new JButton(new ImageIcon(new ImageIcon("D:/Projects/Java GUI/javaSwing/Resources/new.png")
                .getImage().getScaledInstance(buttonSize, buttonSize, java.awt.Image.SCALE_SMOOTH), "New"));

        buttons[2] = new JButton(new ImageIcon(new ImageIcon("D:/Projects/Java GUI/javaSwing/Resources/cut.png")
                .getImage().getScaledInstance(buttonSize, buttonSize, java.awt.Image.SCALE_SMOOTH), "Cut"));

        buttons[3] = new JButton(new ImageIcon(new ImageIcon("D:/Projects/Java GUI/javaSwing/Resources/copy.png")
                .getImage().getScaledInstance(buttonSize, buttonSize, java.awt.Image.SCALE_SMOOTH), "Copy"));

        buttons[4] = new JButton(new ImageIcon(new ImageIcon("D:/Projects/Java GUI/javaSwing/Resources/paste.png")
                .getImage().getScaledInstance(buttonSize, buttonSize, java.awt.Image.SCALE_SMOOTH), "Paste"));

        buttons[5] = new JButton(new ImageIcon(new ImageIcon("D:/Projects/Java GUI/javaSwing/Resources/split.png")
                .getImage().getScaledInstance(buttonSize, buttonSize, java.awt.Image.SCALE_SMOOTH), "Split"));

        buttons[6] = new JButton(new ImageIcon(new ImageIcon("D:/Projects/Java GUI/javaSwing/Resources/close.png")
                .getImage().getScaledInstance(buttonSize, buttonSize, java.awt.Image.SCALE_SMOOTH), "Close"));

        for (JButton button : buttons) {
            bar.add(button);
            bar.addSeparator();
        }

        text = new JTextArea();
        this.add(bar, BorderLayout.NORTH);
        this.add(new JScrollPane(text), BorderLayout.CENTER);

        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem save = new JMenuItem("save");
        JMenuItem open = new JMenuItem("open");
        file.add(save);
        file.addSeparator();
        file.add(open);
        menu.add(file);

        buttons[1].setActionCommand("open");
        buttons[1].addActionListener((ActionEvent e) -> {
            openFile();
        });
        open.addActionListener((ActionEvent e) -> openFile());
        buttons[0].addActionListener((ActionEvent e)->colorChooser());

        this.setJMenuBar(menu);

        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // you can like wise add all the functionalities to all the above mentioned
    // buttons.

    private void colorChooser() {
        Color color = JColorChooser.showDialog(this, "Font color", Color.red);
        text.setForeground(color);
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();

        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            String str = new String(b);
            text.setText(str);
            fis.close();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        MenuBarToolBarDemo m = new MenuBarToolBarDemo();
        m.setVisible(true);
    }

}
