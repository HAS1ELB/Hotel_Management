package hotel.swing;

import javax.swing.*;
import hotel.beans.*;

import java.awt.*;
import java.awt.event.*;

public class ReservationWindow extends JFrame implements ActionListener {
	
	public static Reservation reservation = new Reservation();
	public static Client client = new Client();
    
    JPanel infoPanel;
    LabeledTextField idNumber;
    LabeledTextField firstName, lastName,age,address,contactNumber;
    JButton nextButton, resetButton, mainMenuButton;

    public ReservationWindow() {
        
        infoPanel = new JPanel();

        
        firstName = new LabeledTextField("First Name:", 20, 100);
        lastName = new LabeledTextField("Last Name:", 20, 100);
        idNumber = new LabeledTextField("ID Number:", 20, 100);
        age = new LabeledTextField("Age:", 20, 100);
        address = new LabeledTextField("Address:", 20, 100);
        contactNumber = new LabeledTextField("Contact Number:", 20, 100);

        infoPanel.setLayout(new GridLayout(6, 1));
        infoPanel.add(firstName);
        infoPanel.add(lastName);
        infoPanel.add(idNumber);
        infoPanel.add(age);
        infoPanel.add(address);
        infoPanel.add(contactNumber);

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(nextButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(mainMenuButton);

        setLayout(new BorderLayout());

        add(infoPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setTitle("ADD A CLIENT");
        setLocationRelativeTo(null);
        setResizable(false);
        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
        	try {
                if(idNumber.getText().equals("") || firstName.getText().equals("") || lastName.getText().equals("") || age.getText().equals("") || address.getText().equals("") || contactNumber.getText().equals("")) {
                	JOptionPane.showMessageDialog(null, "All fields must be filled!");
                	resetClient();
                }
                client.setFirstName(firstName.getText());
                client.setLastName(lastName.getText());
                client.setAge(Integer.parseInt(age.getText()));
                client.setAddress(address.getText());
                client.setContact(Integer.parseInt(contactNumber.getText()));
                client.setIdNumber(idNumber.getText());
               
                reservation.setClient(client);
                reservation.setReservationNumber(reservation.getReservationNumber() + 1);
                
                JOptionPane.showMessageDialog(null, client.getFirstName() + " " + client.getLastName() + "\nClient added successfully");
               
                new ReservationDateWindow();
                dispose();
              
            } catch (Exception a) {
            	a.printStackTrace();
            }
        }

        if (e.getSource() == resetButton) {
        	resetClient();
        }

        if (e.getSource() == mainMenuButton) {
            new Main_Window();
            dispose();
        }
    }

    
    private void resetClient() {
    	idNumber.setText("");
        firstName.setText("");
        lastName.setText("");
        age.setText("");
        address.setText("");
        contactNumber.setText("");
    }
    
    public static void main(String[] args) {
        new ReservationWindow();
    }
}
