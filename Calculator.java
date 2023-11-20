import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private JTextField textField;
    private JButton button9;
    private JButton button7;
    private JButton button8;
    private JButton button6;
    private JButton button2;
    private JButton button5;
    private JButton button4;
    private JButton button1;
    private JButton button3;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonMultiplication;
    private JButton buttonDivision;
    private JButton buttonEqually;
    private JButton buttonDot;
    private JButton button00;
    private JPanel Calculator;
    private JButton buttun0;
    private JButton buttonAC;
    private JButton buttonDelete;
    private JButton buttonPlusMinus;
    private JTextField textField1;

    private double op1,op2,result;
    private String opp;


    public Calculator() {

        setContentPane(Calculator);
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setVisible(true);






        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JButton source=(JButton) actionEvent.getSource();
                String  buttonText =source.getText();
                textField.setText(textField.getText()+buttonText);
            }
        };

        JButton[] buttons = {button1, button2, button3, button4, button5,
                button6, button7, button8, button9, buttun0,button00,buttonDot};
        for (JButton button : buttons) {
            button.addActionListener(listener);
        }



        buttonAC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    textField.setText("");

            }
        });
        buttonPlusMinus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textField.getText().contains(".")){
                    double dbl=Double.parseDouble(textField.getText());
                    dbl*=-1;
                    textField.setText(String.valueOf(dbl));
                }else {
                    long longInt=Long.parseLong(textField.getText());
                    longInt*=-1;
                    textField.setText(String.valueOf(longInt));
                }
            }
        });
        buttonPlus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                op1=Double.parseDouble(textField.getText());
                opp="+";
                textField.setText("");
            }
        });
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                op1=Double.parseDouble(textField.getText());
                opp="-";
                textField.setText("");
            }
        });
        buttonMultiplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                op1=Double.parseDouble(textField.getText());
                opp="*";
                textField.setText("");
            }
        });
        buttonDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                op1=Double.parseDouble(textField.getText());
                opp="/";
                textField.setText("");
            }
        });
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String back=null;

            if(!textField.getText().isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder(textField.getText());
                stringBuilder.deleteCharAt(textField.getText().length() - 1);
                back = String.valueOf(stringBuilder);
                textField.setText(back);
}
            }
        });
        buttonEqually.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    op2=Double.parseDouble(textField.getText());

                switch (opp) {
                    case "+":
                        result = op1 + op2;
                        break;
                    case "-":
                        result = op1 - op2;
                        break;
                    case "*":
                        result = op1 * op2;
                        break;
                    case "/":{
                        result = op1 / op2;
                        break;}
                    default:
                        break;
                }

                textField.setText(String.valueOf(result));
            }
        });
    }



    public static void main(String[] args) {
        new Calculator();
    }
}
