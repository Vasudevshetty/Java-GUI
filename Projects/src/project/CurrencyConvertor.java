package Projects.src.project;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Dimension;

public class CurrencyConvertor extends JFrame {

    public CurrencyConvertor() {
        super("Currency Convertor");

        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMaximumSize(new Dimension(400, 500));
    }
}
