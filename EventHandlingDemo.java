import java.awt.Frame;
import java.awt.TextField;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandlingDemo extends Frame
implements ActionListener
{
    TextField text;
    Button button;
    int count = 0;

    public EventHandlingDemo() {
        super("Even handling demo");
        text = new TextField("0", 20);
        button = new Button("Click");

        // this is the first method.
        button.addActionListener(this);


        this.setLayout(new FlowLayout());
        this.add(text);
        this.add(button);
        this.setSize(400, 300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    count++;
    text.setText(String.valueOf(count));
    }

    public static void main(String[] args) {
        EventHandlingDemo e = new EventHandlingDemo();
        e.setVisible(true);
    }
}
