import java.awt.*;
import java.awt.event.*;

public class ListBoxChoiceDemo extends Frame implements ItemListener, ActionListener {
    List l;
    TextArea t;
    Choice c;

    public ListBoxChoiceDemo() {
        l = new List(4, true);
        t = new TextArea(10, 40);
        c = new Choice();

        String[] s = { "Monday", "Tuesday", "Wednesday", "Friday", "Saturday", "Sunday" };
        for (String string : s)
            l.add(string);

        String[] mon = { "Januarary", "Febrauary", "March", "April", "May", "June", "July", "August", "September",
                "October",
                "Novenber", "December" };
        for (String month : mon)
            c.add(month);

        l.addItemListener(this);
        c.addItemListener(this);

        this.setLayout(new FlowLayout());
        this.add(l);
        this.add(t);
        this.add(c);
        
        l.addActionListener(this);

        this.setSize(600, 300);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == l)
            t.setText(l.getSelectedItem() + "\n");
        else if (e.getSource() == c)
            t.append(c.getSelectedItem() + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] list = l.getSelectedItems();
        for(String li : list) t.append(li + "\n");
    }

    public static void main(String args[]) {
        ListBoxChoiceDemo l = new ListBoxChoiceDemo();
        l.setVisible(true);
    }
}
