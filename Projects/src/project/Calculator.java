package Projects.src.project;

import java.awt.*;
import java.awt.event.*;

import Projects.src.otherpackages.NotationConvertor;
import Projects.src.otherpackages.NotationConvertor.NotationType;

public class Calculator extends Frame {
    private Button[] numbers;
    private Button[] operators;
    private TextField display;
    private Button clearButton, equalsButton;

    private StringBuffer expression = new StringBuffer();
    private double result;

    public Calculator() {
        super("Calculator");
        this.setLayout(new BorderLayout());
        this.setMaximumSize(new Dimension(300, 400));
        this.pack();
        this.setResizable(false);

        display = new TextField("", 20);
        display.setFont(new Font("Arail", Font.PLAIN, 24));
        display.setEditable(false);

        this.add(display, BorderLayout.NORTH);

        numbers = new Button[10];
        Panel numberGrid = new Panel(new GridLayout(4, 3));

        for (int i = 0; i <= 9; i++) {
            numbers[i] = new Button(String.valueOf(i));
            numbers[i].setFont(new Font("Arail", Font.BOLD, 18));
            numbers[i].addActionListener((ActionEvent e) -> {
                expression.append(((Button) e.getSource()).getLabel());
                display.setText(expression.toString());
            });
            numberGrid.add(numbers[i]);
        }

        operators = new Button[5];
        Panel operatorGrid = new Panel(new GridLayout(5, 1));
        operators[0] = new Button("+");
        operators[1] = new Button("-");
        operators[2] = new Button("*");
        operators[3] = new Button("/");
        operators[4] = new Button("%");

        for (Button operator : operators) {
            operator.setFont(new Font("Arail", Font.BOLD, 18));
            operator.addActionListener((ActionEvent e) -> {
                expression.append(((Button) e.getSource()).getLabel());
                display.setText(expression.toString());
            });
            operatorGrid.add(operator);
        }

        clearButton = new Button("C");
        clearButton.setFont(new Font("Arail", Font.BOLD, 18));

        clearButton.addActionListener((ActionEvent e) -> {
            expression.delete(0, expression.length());
            display.setText("");
        });

        equalsButton = new Button("=");
        equalsButton.setFont(new Font("Arail", Font.BOLD, 18));

        equalsButton.addActionListener((ActionEvent e) -> {
            result = NotationConvertor.evaulate(NotationConvertor.prefix(expression.toString(), NotationType.infix),
                    NotationType.prefix);
            expression.delete(0, expression.length());
            display.setText(String.valueOf(result));
        });

        this.add(numberGrid, BorderLayout.CENTER);
        this.add(operatorGrid, BorderLayout.EAST);
        this.add(equalsButton, BorderLayout.SOUTH);
        this.add(clearButton, BorderLayout.WEST);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 500);
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.setVisible(true);
    }
}