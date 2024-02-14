import java.awt.*;

class MyFrame extends Frame {
    Label label;
    TextField text;
    Button button;

    public MyFrame() {
        super("My App");
        
        this.setLayout(new FlowLayout());

        label = new Label("Name : ");
        text = new TextField(20);
        button = new Button("Ok");

        this.add(label);
        this.add(text);
        this.add(button);
    }
}

public class FirstApp2 {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();

        frame.setSize(500, 500);
        frame.setVisible(true);

    }
}
