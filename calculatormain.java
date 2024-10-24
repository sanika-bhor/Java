import java.awt.*;
import java.awt.event.*;

class calculatormain extends Frame implements ActionListener, FocusListener {
    Button b1, b2;
    // TextArea t1, t2, t3;
    TextField t1, t2, t3;
    String s1, s2;
    String operator;
    boolean isOperand1Focused = true;

    calculatormain() {

        Panel p1 = new Panel();
        Font f2 = new Font("times new roman", Font.BOLD | Font.ITALIC, 20);
        p1.setLayout(new GridLayout(3, 2, 15, 5));
        // Panel p1 = new Panel();
        // p1.setLayout(new FlowLayout());
        Label l1 = new Label("1st number", Label.RIGHT);
        // t1 = new TextArea(2, 17);
        t1 = new TextField(15);

        l1.setFont(f2);
        t1.setFont(f2);
        p1.add(l1);
        p1.add(t1);

        Label l2 = new Label("2st number", Label.RIGHT);
        // t2 = new TextArea(2, 17);
        t2 = new TextField(15);

        l2.setFont(f2);
        t2.setFont(f2);
        p1.add(l2);
        p1.add(t2);

        Label l3 = new Label("result", Label.RIGHT);
        // t3 = new TextArea(2, 17);
        t3 = new TextField(15);
        l3.setFont(f2);
        t3.setFont(f2);
        p1.add(l3);
        p1.add(t3);

        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);

        // t2 = new TextField(20);
        // t1.setEditable(false);
        // t1.setBounds(5, 50, 450, 80);
        // t1.setBackground(Color.black);

        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(5, 4));
        b1 = new Button("AC");
        b2 = new Button("clear");

        Font f1 = new Font("times new roman", Font.BOLD | Font.ITALIC, 20);

        Button b3 = new Button("%");
        Button b4 = new Button("/");
        Button b5 = new Button("7");
        Button b6 = new Button("8");
        Button b7 = new Button("9");
        Button b8 = new Button("*");
        Button b9 = new Button("4");
        Button b10 = new Button("5");
        Button b11 = new Button("6");
        Button b12 = new Button("-");
        Button b13 = new Button("1");
        Button b14 = new Button("2");
        Button b15 = new Button("3");
        Button b16 = new Button("+");
        Button b17 = new Button("change");
        Button b18 = new Button("0");
        Button b19 = new Button(".");
        Button b20 = new Button("=");

        b1.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f1);
        b4.setFont(f1);
        b5.setFont(f1);
        b6.setFont(f1);
        b7.setFont(f1);
        b8.setFont(f1);
        b9.setFont(f1);
        b10.setFont(f1);
        b11.setFont(f1);
        b12.setFont(f1);
        b13.setFont(f1);
        b14.setFont(f1);
        b15.setFont(f1);
        b16.setFont(f1);
        b17.setFont(f1);
        b18.setFont(f1);
        b19.setFont(f1);
        b20.setFont(f1);

        p2.add(b2);
        p2.add(b1);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.add(b7);
        p2.add(b8);
        p2.add(b9);
        p2.add(b10);
        p2.add(b11);
        p2.add(b12);
        p2.add(b13);
        p2.add(b14);
        p2.add(b15);
        p2.add(b16);
        p2.add(b17);
        p2.add(b18);
        p2.add(b19);
        p2.add(b20);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);
        b17.addActionListener(this);
        b18.addActionListener(this);
        b19.addActionListener(this);
        b20.addActionListener(this);

        t1.addFocusListener(this);
        t2.addFocusListener(this);

        // Panel p3 = new Panel();
        // p3.setLayout(new FlowLayout());
        Panel p4 = new Panel();
        p4.setLayout(new FlowLayout());
        // Label l1 = new Label("ist number");
        // Label l2 = new Label("2st number");
        // Label l3 = new Label("result");
        // p3.add(l1);
        // p3.add(l2);
        // p3.add(l3);

        // setLayout(new BorderLayout());
        // add(p1, BorderLayout.CENTER);
        // add(p2, BorderLayout.SOUTH);
        // add(p3, BorderLayout.NORTH);
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        // add(p3, BorderLayout.EAST);
        add(p4, BorderLayout.SOUTH);

    }

    public void focusGained(FocusEvent fe) {
        if (fe.getSource() == (t1)) {
            isOperand1Focused = true;
        } else if (fe.getSource() == (t2)) {
            isOperand1Focused = false;
        }

    }

    public void focusLost(FocusEvent fe) {
    }

    public void actionPerformed(ActionEvent ae) {
        s1 = t1.getText();
        s2 = t2.getText();
        String s = ae.getActionCommand();

        if (isOperand1Focused) {
            if (s.equals("AC")) {
                t1.setText("");
                t2.setText("");
                t3.setText("");

            } else if (s.equals("clear")) {
                t1.setText("");
                t2.setText("");
                t3.setText("");

            } else if (s.equals("%")) {
                operator = "%";

            } else if (s.equals("/")) {
                operator = "/";

            }

            else if (s.equals("7")) {

                s1 = s1 + "7";
                t1.setText(s1);
            }

            else if (s.equals("8")) {
                s1 = s1 + "8";
                t1.setText(s1);
            }

            else if (s.equals("9")) {
                s1 = s1 + "9";
                t1.setText(s1);

            } else if (s.equals("*")) {
                operator = "*";

            } else if (s.equals("4")) {
                s1 = s1 + "4";
                t1.setText(s1);

            } else if (s.equals("5")) {
                s1 = s1 + "5";
                t1.setText(s1);

            } else if (s.equals("6")) {
                s1 = s1 + "6";
                t1.setText(s1);

            } else if (s.equals("-")) {
                operator = "-";
            } else if (s.equals("1")) {
                s1 = s1 + "1";
                t1.setText(s1);

            } else if (s.equals("2")) {
                s1 = s1 + "2";
                t1.setText(s1);

            } else if (s.equals("3")) {
                s1 = s1 + "3";
                t1.setText(s1);

            } else if (s.equals("+")) {
                // s1 = s1 + "+";
                // t1.setText(s1);
                operator = "+";

            } else if (s.equals("change")) {
                // s1 = s1 + "";
                // t1.setText(s1);

            } else if (s.equals("0")) {
                s1 = s1 + "0";
                t1.setText(s1);

            } else if (s.equals(".")) {
                s1 = s1 + ".";
                t1.setText(s1);
            } else if (s.equals("=")) {

                calculate();

            }
        } else {
            if (s.equals("AC")) {
                t1.setText("");
                t2.setText("");
                t3.setText("");

            } else if (s.equals("clear")) {
                t1.setText("");
                t2.setText("");
                t3.setText("");

            } else if (s.equals("%")) {
                operator = "%";

            } else if (s.equals("/")) {
                operator = "/";

            }

            else if (s.equals("7")) {

                s2 = s2 + "7";
                t2.setText(s2);
            }

            else if (s.equals("8")) {
                s2 = s2 + "8";
                t2.setText(s2);
            }

            else if (s.equals("9")) {
                s2 = s2 + "9";
                t2.setText(s2);

            } else if (s.equals("*")) {
                operator = "*";

            } else if (s.equals("4")) {
                s2 = s2 + "4";
                t2.setText(s2);

            } else if (s.equals("5")) {
                s2 = s2 + "5";
                t2.setText(s2);

            } else if (s.equals("6")) {
                s2 = s2 + "6";
                t2.setText(s2);

            } else if (s.equals("-")) {
                operator = "-";

            } else if (s.equals("1")) {
                s2 = s2 + "1";
                t2.setText(s2);

            } else if (s.equals("2")) {
                s2 = s2 + "2";
                t2.setText(s2);

            } else if (s.equals("3")) {
                s2 = s2 + "3";
                t2.setText(s2);

            } else if (s.equals("+")) {
                operator = "+";

            } else if (s.equals("change")) {
                // s1 = s1 + "";
                // t1.setText(s1);

            } else if (s.equals("0")) {
                s2 = s2 + "0";
                t2.setText(s2);

            } else if (s.equals(".")) {
                s2 = s2 + ".";
                t2.setText(s2);
            } else if (s.equals("=")) {
                calculate();
            }
        }

    }

    private void calculate() {
        if (!s1.isEmpty() && !s2.isEmpty()) {
            double operand1 = Double.parseDouble(s1);
            double operand2 = Double.parseDouble(s2);
            double result = 0.0;

            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 != 0) {
                        result = operand1 / operand2;
                    } else {
                        t1.setText("Error");
                        t2.setText("Error");

                    }
                    break;
                case "%":
                    result = operand1 % operand2;
                    break;
            }

            t3.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        calculatormain g1 = new calculatormain();
        g1.setVisible(true);
        g1.setSize(400, 450);
        g1.setTitle("calculator");
    }
}
