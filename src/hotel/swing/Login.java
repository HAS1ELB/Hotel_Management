package hotel.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    private LabeledTextField usernameField, passwordField;
    private ButtonPanel buttonPanel;

    public Login() {
        setTitle("HOTEL INDIA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel connectionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        connectionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameField = new LabeledTextField("Username:", 15, 100);
        passwordField = new LabeledTextField("Password:", 15, 100, true);

        connectionPanel.add(usernameField);
        connectionPanel.add(passwordField);

        add(connectionPanel);

        String[] buttonLabels = {"Login"};
        buttonPanel = new ButtonPanel(buttonLabels);
        JButton loginButton = (JButton) buttonPanel.getComponent(0);
        loginButton.addActionListener(this);

        JPanel buttonPanelContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanelContainer.add(buttonPanel);

        add(buttonPanelContainer);

        setResizable(false);

        setSize(290, 280);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    	
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        boolean isLoginValid = false;
        
        if (username.equals("kamal") && password.equals("0000")) {
            isLoginValid = true;
        } else if (username.equals("walid") && password.equals("0000")) {
            isLoginValid = true;
        } else if (username.equals("hassan") && password.equals("0000")) {
            isLoginValid = true;
        } else if (username.equals("abdellah") && password.equals("0000")) {
            isLoginValid = true;
        }
        
        if (isLoginValid) {
            JOptionPane.showMessageDialog(this, "Login successful");
            new Main_Window().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect credentials");
            resetFields();
        }
    }

    private void resetFields() {
        usernameField.setText("");
        passwordField.setText("");
    }

    public static void main(String[] args) {
        new Login();
    }
}
