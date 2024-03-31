package hotel.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main_Window extends JFrame implements ActionListener  {
	
    ButtonPanel buttonPanel1, buttonPanel2;
    JTextField textfiled ; 

    public Main_Window() {
    	
		setLayout(new BorderLayout());
		
		String[] buttonLabels = {"ADD RESERVATION", "ADD ROOM",};
		String[] buttonLabels2 = {"BACK TO LOGIN","EXIT"};
		
		textfiled = new JTextField("WELCOME TO OUR HOTEL'S HOME PAGE");
		textfiled.setPreferredSize(null);
		textfiled.setEditable(false);
		
		buttonPanel1 = new ButtonPanel(buttonLabels);
		buttonPanel2 = new ButtonPanel(buttonLabels2);
		
		buttonPanel1.setLayout(new FlowLayout());
		buttonPanel2.setLayout(new FlowLayout());
		
		JPanel p  =new JPanel(new FlowLayout());
		p.add(textfiled);
		
		add(p, BorderLayout.NORTH);
		add(buttonPanel1, BorderLayout.CENTER);
		add(buttonPanel2, BorderLayout.SOUTH);
		
		setTitle("HOTEL INDIA");
		setSize(500, 150);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		for (Component component : buttonPanel1.getComponents()) {
            if (component instanceof JButton) {
                ((JButton) component).addActionListener(this);
            }
        }
        for (Component component : buttonPanel2.getComponents()) {
            if (component instanceof JButton) {
                ((JButton) component).addActionListener(this);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() instanceof JButton) {
            JButton sourceButton = (JButton) e.getSource();
            if (sourceButton.getText().equals("ADD RESERVATION")) {
                new ReservationWindow();
            } else if (sourceButton.getText().equals("ADD ROOM")) {
                new AddRoomWindow();
            }else if (sourceButton.getText().equals("BACK TO LOGIN")) {
            	new Login();
            }
        }
        dispose();
    }
	public static void main(String[] args) {
        new Main_Window();
    }
}
