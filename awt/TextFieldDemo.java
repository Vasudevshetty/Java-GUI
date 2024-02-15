import java.awt.*;
import java.awt.event.*;

public class TextFieldDemo extends Frame implements TextListener, ActionListener {
    TextField t;
    Label l1, l2;

    public TextFieldDemo() {
        t = new TextField(20);
        l1 = new Label("No text is entered yet.");
        l2 = new Label("Enter key is not yet pressed.");
        // t.setEchoChar('*'); this is for passwords.

        this.add(l1);
        this.add(t);
        this.add(l2);

        t.addTextListener(this);
        t.addActionListener(this);

        this.setLayout(new FlowLayout());
        this.setSize(400, 400);
    }

    @Override
    public void textValueChanged(TextEvent e) {
        l1.setText(t.getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        l2.setText(l1.getText());
    }

    public static void main(String[] args) {
        TextFieldDemo obj = new TextFieldDemo();
        obj.setVisible(true);
    }
}
