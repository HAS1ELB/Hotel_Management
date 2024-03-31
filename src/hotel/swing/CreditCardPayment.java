package hotel.swing;

import javax.swing.*;

import hotel.save.SaveClient;
import hotel.save.SaveReservation;
import java.awt.*;


public class CreditCardPayment extends JFrame {

    private LabeledTextField cardNumberField;
    private LabeledTextField expirationDateField;
    private LabeledTextField cvvField;
    private JLabel priceLabel; 

    public CreditCardPayment() {
        setTitle("Credit Card Payment");
        setSize(360, 350);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        cardNumberField = new LabeledTextField("Card Number:", 15, 150);
        expirationDateField = new LabeledTextField("Expiration Date:", 15, 150);
        cvvField = new LabeledTextField("CVV:", 15, 150);
        priceLabel = new JLabel("Price: " + ReservationWindow.reservation.getPrice()+ " DHS"); 
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ButtonPanel paymentButtonPanel = new ButtonPanel(new String[]{"Pay", "Cancel"});

        JButton processButton = (JButton) paymentButtonPanel.getComponent(0);
        JButton cancelButton = (JButton) paymentButtonPanel.getComponent(1);

        processButton.addActionListener(e -> processCreditCardPayment());
        cancelButton.addActionListener(e -> {
            new Payment();
            dispose();
        });

        buttonPanel.add(processButton);
        buttonPanel.add(cancelButton);

        panel.add(cardNumberField);
        panel.add(expirationDateField);
        panel.add(cvvField);
        panel.add(priceLabel); 
        panel.add(new JLabel()); 
        panel.add(buttonPanel);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void processCreditCardPayment() {
    	
    	ReservationWindow.reservation.setPaymentMethod("Credit Card Payment");
    	
        String cardNumber = cardNumberField.getText();
        String expirationDate = expirationDateField.getText();
        String cvv = cvvField.getText();

        JOptionPane.showMessageDialog(this, "Credit Card Payment Successful.\n" +
                "Card Number: " + cardNumber + "\n" +
                "Expiration Date: " + expirationDate + "\n" +
                "CVV: " + cvv + "\n" +
                "Price: " + ReservationWindow.reservation.getPrice());

        new SaveReservation(CreditCardPayment.this, ReservationWindow.reservation);
        new SaveClient(CreditCardPayment.this, ReservationWindow.client);
        openSummaryInfo();
        dispose();
    }

//    private void savePaymentInfo(String paymentMethod) {
//        
//    	try (FileWriter reservationInfoWriter = new FileWriter("Data_Base/ReservationInfo.txt", true)) {
//    		reservationInfoWriter.write(ReservationWindow.reservation.toString());
//    		reservationInfoWriter.write("\n=====================================================");
//        	FileWriter clientInfoWriter = new FileWriter("Data_Base/clientInfo.txt", true);
//        	clientInfoWriter.write(ReservationWindow.client.toString());
//            clientInfoWriter.write("\n=====================================================");
//            clientInfoWriter.close();
//    	
//        } catch (IOException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error writing to ReservationInfo.txt file.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }

    private void openSummaryInfo() {
    	new ReservationSummary(ReservationWindow.reservation);
        dispose();
    }

    public static void main(String[] args) {
        new CreditCardPayment();
    }
}
