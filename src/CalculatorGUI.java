import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    public CalculatorGUI() {
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tal1 = Integer.parseInt(input1TextField.getText());
                int tal2 = Integer.parseInt(input2TextField.getText());
                answer.setText(""+(tal1+tal2));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CalculatorGUI");
        frame.setContentPane(new CalculatorGUI().calc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(new Dimension(640, 480));
        frame.setVisible(true);
    }
    private JPanel calc;
    private JTextField input1TextField;
    private JTextField input2TextField;
    private JLabel answer;
    private JButton calculateButton;

}
