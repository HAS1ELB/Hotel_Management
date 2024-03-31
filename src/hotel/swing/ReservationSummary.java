package hotel.swing;

import hotel.beans.Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationSummary extends JFrame {

    private JTextArea textArea;

    public ReservationSummary(Reservation reservation) {
        setTitle("Reservation Summary");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonPanel.add(quitButton);

        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Main_Window();
                dispose();
            }
        });

        buttonPanel.add(mainMenuButton);

        add(buttonPanel, BorderLayout.SOUTH);

        displayReservation(reservation);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void displayReservation(Reservation reservation) {
        if (reservation != null) {
            textArea.append(reservation.toString());
        } else {
            textArea.append("No reservation found.");
        }
    }

    public static void main(String[] args) {
        new ReservationSummary(ReservationWindow.reservation);
    }
}
