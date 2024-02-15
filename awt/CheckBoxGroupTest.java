import java.awt.*;
import java.awt.event.*;

public class CheckBoxGroupTest extends Frame implements ItemListener {
    Label label;
    Checkbox checks[];
    CheckboxGroup group;

    public CheckBoxGroupTest() {
        super("CheckBox Test");
        checks = new Checkbox[3];
        label = new Label("Nothing is selected.");
        group = new CheckboxGroup();
        checks[0] = new Checkbox("Male", false, group);
        checks[1] = new Checkbox("Female", false, group);
        checks[2] = new Checkbox("Others", false, group);
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
        CheckBoxGroupTest c = new CheckBoxGroupTest();
        c.setVisible(true);
    }
}