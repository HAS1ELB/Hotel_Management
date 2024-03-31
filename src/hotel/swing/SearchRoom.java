package hotel.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchRoom extends JFrame implements ActionListener {

    private JComboBox<String> roomTypeComboBox;
    private JComboBox<Integer> bedCountComboBox;
    private JCheckBox wifiCheckBox, tvCheckBox, acCheckBox;
    private ButtonPanel buttonPanel;

    private String selectedRoomType;
    private int selectedBedCount;
    private boolean selectedWifi, selectedTV,selectedAC ;


    public SearchRoom() {
    	
        setTitle("SEARCH ROOM");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel roomTypePanel = new JPanel();
        roomTypePanel.add(new JLabel("Room Type:"));
        roomTypeComboBox = new JComboBox<>(new String[]{"Single", "Double", "Suite"});
        roomTypePanel.add(roomTypeComboBox);

        JPanel bedCountPanel = new JPanel();
        bedCountPanel.add(new JLabel("Number of Beds:"));
        bedCountComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4});
        bedCountPanel.add(bedCountComboBox);

        JPanel optionsPanel = new JPanel();
        optionsPanel.add(new JLabel("Options:"));
        wifiCheckBox = new JCheckBox("Wi-Fi");
        tvCheckBox = new JCheckBox("TV");
        acCheckBox = new JCheckBox("Air Conditioning");
        optionsPanel.add(wifiCheckBox);
        optionsPanel.add(tvCheckBox);
        optionsPanel.add(acCheckBox);

        String[] buttonLabels = {"CONFIRM", "BACK"};
        buttonPanel = new ButtonPanel(buttonLabels);
        JButton confirmButton = (JButton) buttonPanel.getComponent(0);
        confirmButton.addActionListener(this);
        JButton backButton = (JButton) buttonPanel.getComponent(1);
        backButton.addActionListener(this);
        JPanel buttonPanelContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));

        buttonPanelContainer.add(buttonPanel);

        mainPanel.add(roomTypePanel);
        mainPanel.add(bedCountPanel);
        mainPanel.add(optionsPanel);
        mainPanel.add(buttonPanelContainer);

        add(mainPanel);

        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonPanel.getComponent(0)) {
            confirmButtonAction();
        } else if (e.getSource() == buttonPanel.getComponent(1)) {
            new ReservationDateWindow();
            dispose();
        }
    }	
    

    private void confirmButtonAction() {
    	
        selectedRoomType = (String) roomTypeComboBox.getSelectedItem();
        selectedBedCount = (int) bedCountComboBox.getSelectedItem();
        selectedWifi = wifiCheckBox.isSelected();
        selectedTV = tvCheckBox.isSelected();
        selectedAC = acCheckBox.isSelected();

        new RoomResultWindow(selectedRoomType, selectedBedCount, selectedWifi, selectedTV, selectedAC);

        dispose();
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
