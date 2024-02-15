import java.awt.Frame;
import java.awt.TextField;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandlingDemo extends Frame
// implements ActionListener
{
    TextField text;
    Button button;
    int count = 0;

    public EventHandlingDemo() {
        super("Even handling demo");
        text = new TextField(20);
        button = new Button("Click");

        // this is the first method.
        // button.addActionListener(this);

        // this is the second method using a inner class.
        // button.addActionListener(new MyListener());

        // the third method is.
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                count++;
                text.setText(String.valueOf(count));
            }
        });

        this.setLayout(new FlowLayout());
        this.add(text);
        this.add(button);
        this.setSize(400, 300);
    }

    // class MyListener implements ActionListener{
    // // the second method using a inner class.
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // count++;
    // text.setText(String.valueOf(count));
    // }
    // }

    public static void main(String[] args) {
        EventHandlingDemo e = new EventHandlingDemo();
        e.setVisible(true);
    }
}
