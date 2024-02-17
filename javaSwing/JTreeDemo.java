package javaSwing;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.tree.*;
import java.io.*;

public class JTreeDemo extends JFrame {
    JLabel label;
    JTree tree;

    public JTreeDemo() {
        super("JTree Demo");

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("D://Projects/javaDSA");
        File f = new File("D://Projects/javaDSA");
        for (File x : f.listFiles()) {
            if (x.isDirectory()) {
                DefaultMutableTreeNode child = new DefaultMutableTreeNode(x.getName());
                for (File y : x.listFiles())
                    child.add(new DefaultMutableTreeNode(y.getName()));
                root.add(child);
            } else
                root.add(new DefaultMutableTreeNode(x.getName()));
        }

        tree = new JTree(root);
        JScrollPane scroll = new JScrollPane(tree);

        tree.addTreeSelectionListener((TreeSelectionEvent e) -> {
            label.setText(e.getPath().toString());
        });

        label = new JLabel("No file selected");

        this.add(scroll, BorderLayout.CENTER);
        this.add(label, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
    }

    public static void main(String[] args) {
        JTreeDemo t = new JTreeDemo();
        t.setVisible(true);
    }
}
