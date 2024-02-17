package javaSwing;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

public class SliderProgressBarDemo extends JFrame {
    JPanel p1, p2, p3;
    JSlider slider;
    JProgressBar progress;
    int w = 50;

    public SliderProgressBarDemo() {
        super("Slider and progress bar demo.");

        slider = new JSlider(0, 100, 50);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        progress = new JProgressBar();
        progress.setString("0%");
        progress.setStringPainted(true);

        p1 = new JPanel();
        p2 = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawOval(200, 200, w, w);
            }
        };
        p3 = new JPanel();

        p1.add(slider);
        p3.add(progress);

        this.add(p2, BorderLayout.CENTER);
        this.add(p1, BorderLayout.NORTH);
        this.add(p3, BorderLayout.SOUTH);

        slider.addChangeListener((ChangeEvent e) -> {
            w = slider.getValue();
            repaint();
            progress.setString(w + "%");
            progress.setValue(w);
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
    }

    public static void main(String[] args) {
        SliderProgressBarDemo s = new SliderProgressBarDemo();
        s.setVisible(true);
    }
}
