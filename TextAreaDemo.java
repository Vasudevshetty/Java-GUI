import java.awt.*;
import java.awt.event.*;

public class TextAreaDemo extends Frame {
    TextArea ta;
    TextField tf;
    Label l;
    Button b;

    public TextAreaDemo() {
        ta = new TextArea(10, 30);
        tf = new TextField(20);
        l = new Label("No text entered.");
        b = new Button("Click");
    
        this.setLayout(new FlowLayout());

        this.add(ta);
        this.add(l);
        this.add(tf);
        this.add(b);
    
        b.addActionListener(new Handler());

        this.setSize(400,400);    
    }

    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            l.setText(ta.getSelectedText());
            ta.append(tf.getText());
        }
    }

    public static void main(String[] args) {
        TextAreaDemo t = new TextAreaDemo();
        t.setVisible(true);
    }
}
