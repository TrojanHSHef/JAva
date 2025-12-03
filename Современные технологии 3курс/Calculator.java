import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JTextField display;
    private double result;
    private String currentOperation;
    private boolean startNewNumber = true;

    public Calculator() {
        setTitle("Калькулятор");
        setSize(300, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(new ButtonClickListener());
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if (cmd.matches("[0-9]") || cmd.equals(".")) {
                if (startNewNumber) {
                    display.setText(cmd.equals(".") ? "0." : "");
                    startNewNumber = false;
                }
                display.setText(display.getText() + cmd);
            } else if (cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")) {
                result = Double.parseDouble(display.getText());
                currentOperation = cmd;
                startNewNumber = true;
            } else if (cmd.equals("=")) {
                double secondOperand = Double.parseDouble(display.getText());
                switch (currentOperation) {
                    case "+": result += secondOperand; break;
                    case "-": result -= secondOperand; break;
                    case "*": result *= secondOperand; break;
                    case "/": 
                        if (secondOperand != 0) {
                            result /= secondOperand;
                        } else {
                            display.setText("Ошибка");
                            startNewNumber = true;
                            return;
                        }
                        break;
                }
                // Отображаем целое число, если результат целый
                if (result == (long) result) {
                    display.setText(String.valueOf((long) result));
                } else {
                    display.setText(String.valueOf(result));
                }
                startNewNumber = true;
            } else if (cmd.equals("C")) {
                display.setText("0");
                result = 0;
                currentOperation = "";
                startNewNumber = true;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculator().setVisible(true);
        });
    }
}
