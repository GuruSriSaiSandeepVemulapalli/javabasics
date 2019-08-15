package JFrame.BMICalculator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BMICalculator extends JFrame {

    private JTextField txtName;
    private JTextField txtFeet;
    private JTextField txtInches;
    private JTextField txtWeight;
    private JTextArea result;

    /**
     * Create the frame.
     */
    public BMICalculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtName = new JTextField();
        txtName.setBounds(21, 101, 86, 20);
        contentPane.add(txtName);
        txtName.setColumns(10);

        JButton btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int feet, inches, totalinches, weight = 0;
                double bmi;
                // checking to make sure Name field has been entered.
                if (txtName.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "You left the name blank.");
                    txtName.grabFocus();
                    return;
                }
                // Data Validation for Feet text box
                if (txtFeet.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "You left the feet field blank.");
                    txtFeet.grabFocus();
                    return;
                }
                if (isNumber(txtFeet.getText())) {
                    feet = Integer.parseInt(txtFeet.getText());
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "Please enter feet as a number.");
                    txtFeet.grabFocus();
                    return;
                }
                // Data validation for inches (blank field will be 0)
                if (txtInches.getText().equals("")) {
                    inches = 0;
                    txtInches.setText("0");
                }
                else if (isNumber(txtInches.getText())) {
                    inches = Integer.parseInt(txtInches.getText());
                }
                else {
                    // user has non-number entered in inches
                    JOptionPane.showMessageDialog(null,
                            "Inches must be entered as a number.");
                    txtInches.grabFocus();
                    return;
                }
                // Data validation for weight
                if (txtWeight.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "You must enter your weight");
                    txtWeight.grabFocus();
                    return;
                }
                if (isNumber(txtWeight.getText())) {
                    weight = Integer.parseInt(txtWeight.getText());
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "You must enter your weight as a whole number.");
                    txtWeight.grabFocus();
                }
                // Calculate the BMI and produce the results
                bmi = weight / (feet * inches);
                Graphics graphics = getGraphics();
                int x = 20;
                int y = 100;
                graphics.drawString("Result BMI:" + BMI_calculate(weight, feet, inches),x, y);
            }
        });
        btnNewButton.setBounds(99, 228, 89, 23);
        contentPane.add(btnNewButton);

        JTextArea txtrWelcome = new JTextArea();
        txtrWelcome.setTabSize(4);
        txtrWelcome.setBackground(UIManager.getColor("Button.background"));
        txtrWelcome.setFont(new Font("Arial", Font.PLAIN, 12));
        txtrWelcome.setLineWrap(true);txtrWelcome.setBounds(10, 11, 200, 78);
        contentPane.add(txtrWelcome);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(111, 104, 46, 14);
        contentPane.add(lblName);

        JLabel lblHeight = new JLabel("Height");
        lblHeight.setBounds(21, 136, 46, 14);
        contentPane.add(lblHeight);

        txtFeet = new JTextField();
        txtFeet.setHorizontalAlignment(SwingConstants.RIGHT);
        txtFeet.setBounds(71, 133, 46, 20);
        contentPane.add(txtFeet);
        txtFeet.setColumns(10);

        JLabel lblFt = new JLabel("ft.");
        lblFt.setBounds(121, 136, 12, 14);
        contentPane.add(lblFt);

        txtInches = new JTextField();
        txtInches.setHorizontalAlignment(SwingConstants.RIGHT);
        txtInches.setColumns(10);
        txtInches.setBounds(139, 133, 46, 20);
        contentPane.add(txtInches);

        JLabel lblIn = new JLabel("in.");
        lblIn.setBounds(189, 136, 46, 14);
        contentPane.add(lblIn);

        JLabel lblWeight = new JLabel("Weight");
        lblWeight.setBounds(21, 164, 46, 14);
        contentPane.add(lblWeight);

        txtWeight = new JTextField();
        txtWeight.setHorizontalAlignment(SwingConstants.RIGHT);
        txtWeight.setColumns(10);
        txtWeight.setBounds(71, 161, 46, 20);
        contentPane.add(txtWeight);

        JLabel lblLb = new JLabel("lb.");
        lblLb.setBounds(121, 164, 46, 14);
        contentPane.add(lblLb);
    }

    private static double BMI_calculate(double weight, int feet, int inches){
        double bmi = weight/ (feet * inches);
        return bmi;
    }
    private static boolean isNumber(String n) {
        try {
            Integer.parseInt(n);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

}
