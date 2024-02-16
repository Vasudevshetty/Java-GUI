package Projects.src.project;

import java.awt.*;
import java.awt.event.*;

import Projects.src.otherpackages.NotationConvertor;
import Projects.src.otherpackages.NotationConvertor.NotationType;

/**
 * The simple project which is a calculator, for now works on single digit
 * binary operations only (opeartions are limited.)
 * The project is built upon simple basic awt classes, and the logic behind is
 * to take the expression encountered from the display(user)
 * and conver the expression either to prefix\postfix using custom built
 * NotationConvertor utility class (src/otherpackages) and
 * evaulate the expression.
 */
public class Calculator extends Frame {
    private Button[] numbers;
    private Button[] operators;
    private TextField display;
    private Button clearButton, equalsButton;

    private StringBuffer expression = new StringBuffer();
    private double result;

    /**
     * The object created is a calcualtor with very simple frame outlook which is
     * built upon awt.
     */
    public Calculator() {
        super("Calculator");
        this.setLayout(new BorderLayout());

        // added the max size it cannot be greater than that and cannot be maximised
        // either.
        this.setMaximumSize(new Dimension(300, 400));
        this.pack();
        this.setResizable(false);

        display = new TextField("", 20);
        display.setFont(new Font("Arail", Font.PLAIN, 24));
        display.setEditable(false);

        this.add(display, BorderLayout.NORTH);

        // the number panel which contains 0-9
        numbers = new Button[10];
        Panel numberGrid = new Panel(new GridLayout(4, 3));

        // the button's are initalised and the event is handled (action event)
        for (int i = 0; i <= 9; i++) {
            numbers[i] = new Button(String.valueOf(i));
            numbers[i].setFont(new Font("Arail", Font.BOLD, 18));
            numbers[i].addActionListener((ActionEvent e) -> { /* the lambda expression checks out the digit (button)
                                                               entered and puts up in the expresion stringbuffer.*/
                expression.append(((Button) e.getSource()).getLabel());
                display.setText(expression.toString());
            });
            numberGrid.add(numbers[i]);
        }

        // the operator panel (+ - * / %)
        operators = new Button[5];
        Panel operatorGrid = new Panel(new GridLayout(5, 1));
        operators[0] = new Button("+");
        operators[1] = new Button("-");
        operators[2] = new Button("*");
        operators[3] = new Button("/");
        operators[4] = new Button("%");

        // the buttons are initalsied and the event is handled.
        for (Button operator : operators) {
            operator.setFont(new Font("Arail", Font.BOLD, 18));
            operator.addActionListener((ActionEvent e) -> {
                /*The lambda expresion chekcs out teh operator is pressed(button) (clicked) and adds up the 
                 * expression stringbuffer
                 */
                expression.append(((Button) e.getSource()).getLabel());
                display.setText(expression.toString());
            });
            operatorGrid.add(operator);
        }

        clearButton = new Button("C");
        clearButton.setFont(new Font("Arail", Font.BOLD, 18));

        // clearbutton logic
        clearButton.addActionListener((ActionEvent e) -> {
            expression.delete(0, expression.length());
            display.setText("");
        });

        equalsButton = new Button("=");
        equalsButton.setFont(new Font("Arail", Font.BOLD, 18));

        // equals button logix.
        equalsButton.addActionListener((ActionEvent e) -> {
            /*
             *  the expression hence found upon user interaction is sent to a custom created NotaitonConvertor utility class
             * (source : Projects/src/otherprojects/) and the expression is first converted to prefix/postfix(here prefix) and 
             * the expression is evaulated from the evaulate function and hence obtained result is added to the display text feild.
             */
            result = NotationConvertor.evaulate(NotationConvertor.prefix(expression.toString(), NotationType.infix),
                    NotationType.prefix);
            expression.delete(0, expression.length());
            display.setText(String.valueOf(result));
        });

        // organise the frame
        this.add(numberGrid, BorderLayout.CENTER);
        this.add(operatorGrid, BorderLayout.EAST);
        this.add(equalsButton, BorderLayout.SOUTH);
        this.add(clearButton, BorderLayout.WEST);

        // closing button logic.
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