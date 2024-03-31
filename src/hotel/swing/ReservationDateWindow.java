package hotel.swing;

import javax.swing.*;
import hotel.beans.*;

import java.awt.*;
import java.awt.event.*;

public class ReservationDateWindow extends JFrame implements ActionListener {

    private JComboBox<Integer> dayComboBox, monthComboBox, yearComboBox;
    private LabeledTextField stayDurationField;
    private ButtonPanel buttonPanel;

    public ReservationDateWindow() {
    	
        setTitle("RESERVATION DATE");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel();
        
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        dayComboBox = new JComboBox<>(getDays());
        monthComboBox = new JComboBox<>(getMonths());
        yearComboBox = new JComboBox<>(getYears());

        stayDurationField = new LabeledTextField("Stay Duration:", 10, 100);

        inputPanel.add(createLabelAndComponentPanel("Arrival Day:", dayComboBox));
        inputPanel.add(createLabelAndComponentPanel("Arrival Month:", monthComboBox));
        inputPanel.add(createLabelAndComponentPanel("Arrival Year:", yearComboBox));

        JPanel centeredPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centeredPanel.add(stayDurationField);
        inputPanel.add(centeredPanel);
        
        mainPanel.add(inputPanel, BorderLayout.CENTER);

        buttonPanel = new ButtonPanel(new String[]{"Next", "Reset", "Back"});
        
        JButton nextButton = (JButton) buttonPanel.getComponent(0);
        nextButton.addActionListener(this);
        JButton resetButton = (JButton) buttonPanel.getComponent(1);
        resetButton.addActionListener(this);
        JButton backButton = (JButton) buttonPanel.getComponent(2);
        backButton.addActionListener(this);

        JPanel buttonPanelContainer = new JPanel();
        buttonPanelContainer.add(buttonPanel);

        mainPanel.add(buttonPanelContainer, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    private JPanel createLabelAndComponentPanel(String labelText, JComponent component) {
        JPanel labelAndComponentPanel = new JPanel();
        labelAndComponentPanel.add(new JLabel(labelText));
        labelAndComponentPanel.add(component);
        return labelAndComponentPanel;
    }

    private Integer[] getDays() {
        return new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    }

    private Integer[] getMonths() {
        return new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    }

    private Integer[] getYears() {
        return new Integer[]{2024, 2025, 2026, 2027};
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonPanel.getComponent(0)) {
            nextButtonAction();
        } else if (e.getSource() == buttonPanel.getComponent(1)) {
            resetDateInfo();
        } else if (e.getSource() == buttonPanel.getComponent(2)) {
            new ReservationWindow();
            dispose();
        }
    }

    private void nextButtonAction() {
        Date dateInfo = new Date((int) dayComboBox.getSelectedItem(), (int) monthComboBox.getSelectedItem(), (int) yearComboBox.getSelectedItem());
        
        if(dateIsOk(dateInfo)== true) {	
        ReservationWindow.reservation.setDate(dateInfo);
        ReservationWindow.reservation.setDurationInDays(Integer.parseInt(stayDurationField.getText()));
    
        JOptionPane.showMessageDialog(ReservationDateWindow.this, "Reservation information saved successfully!");

        new SearchRoom();
        dispose();
    	}
        else
        	JOptionPane.showMessageDialog(ReservationDateWindow.this, "Invalid Date! \n Try another one.");
        	resetDateInfo();
        
    }

    private boolean dateIsOk(Date dateInfo) {
        int day = dateInfo.getDay();
        int month = dateInfo.getMonth();
        int year = dateInfo.getYear();
    
        boolean testCheck = false;
    
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            testCheck = day >= 1 && day <= 30;
        } else if (month == 2) {
            if (day >= 1 && day <= 28) {
                testCheck = true;
            } else if (day == 29) {
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    testCheck = true;
                } else {
                    testCheck = false;
                }
            }
        } else {
            testCheck = day >= 1 && day <= 31;
        }  
        return testCheck;
    }
    

	private void resetDateInfo() {
        dayComboBox.setSelectedIndex(0);
        monthComboBox.setSelectedIndex(0);
        yearComboBox.setSelectedIndex(0);
        stayDurationField.setText("1");
    }

    public static void main(String[] args) {
        new ReservationDateWindow();
    }
}
