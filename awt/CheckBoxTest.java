import java.awt.*;
import java.awt.event.*;

public class CheckBoxTest extends Frame implements ItemListener {
    Label label;
    Checkbox checks[];

    public CheckBoxTest() {
        super("CheckBox Test");
        checks = new Checkbox[3];
        label = new Label("Nothing is selected.");

        checks[0] = new Checkbox("C");
        checks[1] = new Checkbox("C++");
        checks[2] = new Checkbox("Java");
        this.setLayout(new FlowLayout());

        this.add(label);
        for (Checkbox check : checks) {
            this.add(check);
            check.addItemListener(this);
        }

        this.setSize(400, 400);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String str = "";
        for (Checkbox check : checks) {
            if (check.getState())
                str = str + " " + check.getLabel();
        }
        if (str.isEmpty())
            str = "Nothing is selected.";
        label.setText(str);
    }

    public static void main(String args[]) {
        CheckBoxTest c = new CheckBoxTest();
        c.setVisible(true);
    }
}
