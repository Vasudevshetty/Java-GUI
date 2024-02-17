package javaSwing;

import java.awt.event.ActionEvent;

import javax.swing.*;

class MyInternalFrame extends JInternalFrame {
    private static int objCount = 0;
    JTextArea ta;
    JScrollPane jsp;

    public MyInternalFrame() {
        super("Document " + (++objCount), true, true, true, true);
        ta = new JTextArea();
        jsp = new JScrollPane(ta);
        this.add(jsp);

        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem m1 = new JMenuItem("Save");

        file.add(m1);
        mb.add(file);
        setJMenuBar(mb);

        setSize(300, 300);
        setLocation(50, 50);
        setVisible(true);
    }
}

public class InternalFrameDemo extends JFrame {
    JDesktopPane jp;

    public InternalFrameDemo() {
        super("Internal Frame Demo");

        jp = new JDesktopPane();
        setContentPane(jp);

        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("Document");
        JMenuItem m1 = new JMenuItem("New");

        file.add(m1);
        mb.add(file);
        setJMenuBar(mb);

        m1.addActionListener((ActionEvent e) -> {
            MyInternalFrame mi = new MyInternalFrame();
            jp.add(mi);
        });

        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        InternalFrameDemo i = new InternalFrameDemo();
        i.setVisible(true);
    }
}
