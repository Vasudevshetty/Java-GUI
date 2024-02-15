import java.awt.*;

public class FirstApp {
    public static void main(String args[]) {
        Frame frame = new Frame("My first App");
        frame.setLayout(new FlowLayout());

        Button button = new Button("Ok");
        Label label = new Label("Name");
        TextField text = new TextField(20);

        frame.add(label);
        frame.add(text);
        frame.add(button);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}