import java.awt.*;
import java.awt.event.*;

public class ButtonTest extends Frame implements ActionListener {
    int count = 0;
    Button button;
    Label label;

    public ButtonTest() {
        super("Button demo");
        button = new Button("Click");
        label = new Label(String.valueOf(count));

        button.addActionListener(this); // register to the listener.

        this.add(label);
        this.add(button);
        this.setLayout(new FlowLayout());
        this.setSize(500, 500);
    }

    @Override
    public void actionPerformed(ActionEvent e) { // when event occurs.
        count++;
        label.setText(String.valueOf(count));
    }

    public static void main(String args[]) {
        ButtonTest bt = new ButtonTest();
        bt.setVisible(true);
    }
}
