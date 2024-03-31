package hotel.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame {

   
    public Payment() {
    	
        setTitle("Payment Choice");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        ButtonPanel buttonPanel = new ButtonPanel(new String[]{"Credit Card", "Cash", "Back"});

        JButton creditCardButton = (JButton) buttonPanel.getComponent(0);
        JButton cashButton = (JButton) buttonPanel.getComponent(1);
        JButton backButton = (JButton) buttonPanel.getComponent(2);

        creditCardButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	new CreditCardPayment();
                dispose();
            }
        });

        cashButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	new CashPaymentWindow();
                dispose();
            }
        });

        backButton.addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SearchRoom();
            }
        });

        panel.add(creditCardButton);
        panel.add(cashButton);
        panel.add(backButton);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new Payment();
    }
}
