import com.formdev.flatlaf.intellijthemes.FlatCobalt2IJTheme;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class Calculator implements ActionListener {

    final int NUMBER_BUTTONS = 10;
    final int FUNCTION_BUTTONS = 10;
    final boolean IS_VISIBLE = true;
    final boolean IS_RESIZABLE = true;
    double numberOne = 0;
    double numberTwo = 0;
    double result = 0;
    char operator;
    JFrame frame;
    JPanel panel;
    JTextField textField;
    ImageIcon iconOfTheFrame = new ImageIcon("calculator-icon.png");
    Font myFont = new Font("Calculator", Font.BOLD, 30);
    JButton[] numberButtons = new JButton[NUMBER_BUTTONS];
    JButton[] functionButtons = new JButton[FUNCTION_BUTTONS];
    JButton additionButton, subtractionButton, multiplicationButton, divisionButton;
    JButton decimalButton, equalsButton, squareRootButton, squaredNumberButton, deleteButton, clearButton;
    Action[] numberKeys = new Action[NUMBER_BUTTONS];

    Calculator() {

        frame = new JFrame("CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(IS_VISIBLE);
        frame.setResizable(IS_RESIZABLE);
        frame.setSize(470, 620);
        frame.setLocation(1000, 400);
        frame.setIconImage(iconOfTheFrame.getImage());
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 350, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        panel = new JPanel();
        panel.setBounds(50, 100, 350, 350);
        panel.setLayout(new GridLayout(5, 5, 10, 10));

        additionButton = new JButton("+");
        subtractionButton = new JButton("-");
        multiplicationButton = new JButton("*");
        divisionButton = new JButton("/");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        deleteButton = new JButton("DELETE");
        clearButton = new JButton("CLEAR");
        squareRootButton = new JButton("SQRT");
        squaredNumberButton = new JButton("^2");

        functionButtons[0] = additionButton;
        functionButtons[1] = subtractionButton;
        functionButtons[2] = multiplicationButton;
        functionButtons[3] = divisionButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalsButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = squaredNumberButton;
        functionButtons[9] = squareRootButton;

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(additionButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractionButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplicationButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(divisionButton);

        deleteButton.setBounds(80, 430, 145, 50);
        clearButton.setBounds(230, 430, 145, 50);
        squareRootButton.setBounds(80, 500, 145, 50);
        squaredNumberButton.setBounds(230, 500, 145, 50);

        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(squaredNumberButton);
        frame.add(squareRootButton);
        frame.add(textField);
        frame.add(panel);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatCobalt2IJTheme());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numberButtons.length; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimalButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == additionButton) {
            numberOne = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subtractionButton) {
            numberOne = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == multiplicationButton) {
            numberOne = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divisionButton) {
            numberOne = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == squareRootButton) {
            numberOne = Double.parseDouble(textField.getText());
            operator = 'r';
            textField.setText("");
        }
        if (e.getSource() == squaredNumberButton) {
            numberOne = Double.parseDouble(textField.getText());
            operator = 's';
            textField.setText("");
        }
        if (e.getSource() == equalsButton) {
            switch (operator) {
                case '+':
                    numberTwo = Double.parseDouble(textField.getText());
                    result = numberOne + numberTwo;
                    break;
                case '-':
                    numberTwo = Double.parseDouble(textField.getText());
                    result = numberOne - numberTwo;
                    break;
                case '*':
                    numberTwo = Double.parseDouble(textField.getText());
                    result = numberOne * numberTwo;
                    break;
                case '/':
                    numberTwo = Double.parseDouble(textField.getText());
                    result = numberOne / numberTwo;
                    break;
                case 'r':
                    result = Math.sqrt(numberOne);
                    break;
                case 's':
                    result = numberOne * numberOne;
                    break;
            }
            textField.setText(String.valueOf(result));
            numberOne = result;
        }
        if (e.getSource() == clearButton) {
            textField.setText("");
        }
        if (e.getSource() == deleteButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
    }
}