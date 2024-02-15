import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowDemo extends Frame implements WindowListener {
    Label l;

    WindowDemo() {
        super("Window event demo");

        l = new Label();
        this.setLayout(new FlowLayout());
        this.add(l);

        this.addWindowListener(this);
        this.setSize(400, 400);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        l.setText("Window opened.");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        l.setText("Window opened.");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        l.setText("Window Closed.");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        l.setText("Window Iconfied(Maximise).");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        l.setText("Window Deiconfiy(minmize).");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        l.setText("Window Activated.");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        l.setText("Window Deactivated.");
    }

    public static void main(String[] args) {
        WindowDemo d = new WindowDemo();
        d.setVisible(true);
    }
}
