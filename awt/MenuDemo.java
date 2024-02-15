import java.awt.CheckboxMenuItem;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class MenuDemo extends Frame {
    Menu menu, sub;
    MenuItem open, save, close, closeAll;
    CheckboxMenuItem autosave;
    TextField text;

    public MenuDemo() {
        super("Menu demo");

        menu = new Menu("File");
        open = new MenuItem("open");
        save = new MenuItem("save");
        close = new MenuItem("close");
        closeAll = new MenuItem("closeall");
        autosave = new CheckboxMenuItem("autosave", false);

        sub = new Menu("close");

        menu.add(autosave);
        menu.add(open);
        menu.add(save);
        sub.add(close);
        sub.add(closeAll);
        menu.add(sub);
        menu.add(autosave);

        MenuBar bar = new MenuBar();
        bar.add(menu);

        this.setMenuBar(bar);

        this.setLayout(new FlowLayout());
        this.setSize(400, 400);

        text = new TextField(20);
        this.add(text);

        open.addActionListener((ActionEvent e)->{text.setText(open.getLabel());});
        close.addActionListener((ActionEvent e)->{text.setText(close.getLabel());});
        closeAll.addActionListener((ActionEvent e)->{text.setText(closeAll.getLabel());});
        save.addActionListener((ActionEvent e) -> {
            text.setText(save.getLabel());
        });

        autosave.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                if (autosave.getState())
                    text.setText("auto on");
                else
                    text.setText("auto off");
            }
        });
    }

    public static void main(String[] args) {
        MenuDemo m = new MenuDemo();
        m.setVisible(true);
    }
}
