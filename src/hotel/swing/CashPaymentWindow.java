package hotel.swing;

import javax.swing.*;
import hotel.save.SaveClient;
import hotel.save.SaveReservation;
import java.awt.*;


public class CashPaymentWindow extends JFrame {

    private JLabel amountLabel;

    public CashPaymentWindow() {
        setTitle("Cash Payment");
        setSize(320, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        double price = ReservationWindow.reservation.getPrice();
        String message = "Amount to Pay: " + price + " DHS";
        
        amountLabel = new JLabel(message);
        panel2.add(amountLabel);

        JButton payButton = new JButton("Pay");
        JButton cancelButton = new JButton("Cancel");

        payButton.addActionListener(e -> processCashPayment());
        cancelButton.addActionListener(e -> {
            new Payment();
            dispose();
        });
       
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(payButton);
        buttonPanel.add(cancelButton);

        panel.add(panel2,BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void processCashPayment() {
        ReservationWindow.reservation.setPaymentMethod("Cash Payment");
        try {
            double amount = ReservationWindow.reservation.getPrice();
            JOptionPane.showMessageDialog(this, "Cash payment of " + amount + " Dhs done.");

            new SaveReservation(CashPaymentWindow.this, ReservationWindow.reservation);
            new SaveClient(CashPaymentWindow.this, ReservationWindow.client);
            openSummaryReservation();
            dispose();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
            new CashPaymentWindow();
        }
    }

//    private void savePaymentMethod() {
//        try (FileWriter reservationInfoWriter = new FileWriter("Data_Base/ReservationInfo.txt", true)) {
//
//            reservationInfoWriter.write(ReservationWindow.reservation.toString());
//            reservationInfoWriter.write("\n=====================================================");
//            
//            FileWriter clientInfoWriter = new FileWriter("Data_Base/clientInfo.txt", true);
//            clientInfoWriter.write(ReservationWindow.client.toString());
//            clientInfoWriter.write("\n=====================================================");
//            clientInfoWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error writing to ReservationInfo.txt file.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }

    private void openSummaryReservation() {
        new ReservationSummary(ReservationWindow.reservation);
        dispose();
    } 

    public static void main(String[] args) {
        new CashPaymentWindow();
    }
}
