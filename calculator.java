import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator extends Frame implements ActionListener {
    TextField display;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button plus, minus, multiply, division, equals, clear;
    String operator = "";
    double num1 = 0, num2 = 0;

    calculator() {
        display = new TextField("0");
        display.setBounds(50, 50, 300, 30);
        add(display);

        btn0 = new Button("0");
        btn0.setBounds(50, 300, 50, 50);
        btn0.addActionListener(this);

        btn1 = new Button("1");
        btn1.setBounds(110, 300, 50, 50);
        btn1.addActionListener(this);

        btn2 = new Button("2");
        btn2.setBounds(170, 300, 50, 50);
        btn2.addActionListener(this);

        btn3 = new Button("3");
        btn3.setBounds(230, 300, 50, 50);
        btn3.addActionListener(this);

        btn4 = new Button("4");
        btn4.setBounds(50, 360, 50, 50);
        btn4.addActionListener(this);

        btn5 = new Button("5");
        btn5.setBounds(110, 360, 50, 50);
        btn5.addActionListener(this);

        btn6 = new Button("6");
        btn6.setBounds(170, 360, 50, 50);
        btn6.addActionListener(this);

        btn7 = new Button("7");
        btn7.setBounds(230, 360, 50, 50);
        btn7.addActionListener(this);

        btn8 = new Button("8");
        btn8.setBounds(50, 420, 50, 50);
        btn8.addActionListener(this);

        btn9 = new Button("9");
        btn9.setBounds(110, 420, 50, 50);
        btn9.addActionListener(this);

        plus = new Button("+");
        plus.setBounds(170, 420, 50, 50);
        plus.addActionListener(this);

        minus = new Button("-");
        minus.setBounds(230, 420, 50, 50);
        minus.addActionListener(this);

        multiply = new Button("*");
        multiply.setBounds(50, 480, 50, 50);
        multiply.addActionListener(this);

        division = new Button("/");
        division.setBounds(110, 480, 50, 50);
        division.addActionListener(this);

        equals = new Button("=");
        equals.setBounds(170, 480, 50, 50);
        equals.addActionListener(this);

        clear = new Button("Clear");
        clear.setBounds(230, 480, 50, 50);
        clear.addActionListener(this);

        add(btn0);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn7);
        add(btn8);
        add(btn9);
        add(plus);
        add(minus);
        add(multiply);
        add(division);
        add(equals);
        add(clear);

        setSize(400, 600);
        setLayout(null);
        setTitle("Calculator");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();

        if (cm.matches("[0-9]")) {
            if (display.getText().equals("0"))
                display.setText(cm);
            else
                display.setText(display.getText() + cm);
        } else if (cm.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(display.getText());
            operator = cm;
            display.setText("");
        } else if (cm.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            double result = 0;
            switch (operator) {
                case "+": result = num1 + num2;
                break;
                case "-": result = num1 - num2;
                break;
                case "*": result = num1 * num2;
                break;
                case "/": result = (num2 != 0) ? num1 / num2 : 0;
                break;
            }
            display.setText(String.valueOf(result));
        } else if (cm.equals("Clear")) {
            display.setText("0");
            num1 = num2 = 0;
            operator = "";
        }
    }

    public static void main(String[] args) {
        new calculator();
    }
}
