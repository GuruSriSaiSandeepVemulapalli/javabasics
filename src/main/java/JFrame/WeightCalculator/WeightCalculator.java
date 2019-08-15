package JFrame.WeightCalculator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeightCalculator extends JFrame implements ActionListener {
    private JTextField weightField = new JTextField(10);

    WeightCalculator()
    {
        super("Calculate weight");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setResizable(false);

        String title = new String("Please enter your weight in pounds: ");
        add(new JLabel(title));
        add(weightField);
        JButton calcButton = new JButton("Calculate!");
        add(calcButton);
        calcButton.addActionListener(this);

        Container con = getContentPane();
        con.setBackground(Color.DARK_GRAY);
    }

    private static double convertToOunces(double w)
    {
        return (w * 16);
    }
    private static double convertToKilo(double w)
    {
        return (w / 2.204623);
    }
    private static double convertToMetricTon(double w)
    {
        return (w / 2204.623);
    }
    public void actionPerformed(ActionEvent e) {
        Graphics gr = getGraphics();
        String weightString = weightField.getText();
        double weight = Double.parseDouble(weightString);

        gr.setColor(Color.WHITE);
        int x = 20;
        int y = 100;
        gr.fillRect(x - 30, y - 30, 300, 250);

        gr.setColor(Color.BLACK);
        gr.drawString("Ounces: " + convertToOunces(weight), x, y);
        int offset = 25;
        gr.drawString("Kilograms: " + convertToKilo(weight), x, y + offset);
        gr.drawString("Metric tons: " + convertToMetricTon(weight), x, y + (offset *2));
    }
}
