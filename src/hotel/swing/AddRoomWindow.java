package hotel.swing;

import hotel.beans.*;
import hotel.save.SaveRoomInfo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddRoomWindow extends JFrame {

    private LabeledTextField roomNumberField , bedCountField, priceField, stateField;
    private JRadioButton singleRadio, doubleRadio, suiteRadio;
    private JCheckBox wifiCheckBox, tvCheckBox, acCheckBox;

    public AddRoomWindow() {

        setTitle("ADD A ROOM");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        roomNumberField = new LabeledTextField("Room Number:", 10, 120);
        bedCountField = new LabeledTextField("Bed Count:", 10, 120);
        priceField = new LabeledTextField("Price:", 10, 120);

        singleRadio = new JRadioButton("Single");
        doubleRadio = new JRadioButton("Double");
        suiteRadio = new JRadioButton("Suite");

        ButtonGroup roomTypeGroup = new ButtonGroup();
        roomTypeGroup.add(singleRadio);
        roomTypeGroup.add(doubleRadio);
        roomTypeGroup.add(suiteRadio);

        wifiCheckBox = new JCheckBox("Wi-Fi");
        tvCheckBox = new JCheckBox("TV");
        acCheckBox = new JCheckBox("Air Conditioning");
        
        stateField = new LabeledTextField("State:", 10, 120);
        stateField.setText("available");
        stateField.setEditable(false);

        ButtonPanel buttonPanel = new ButtonPanel(new String[]{"ADD ROOM", "RESET", "MAIN MENU"});

        JButton addButton = (JButton) buttonPanel.getComponent(0);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Room room = new Room(roomNumberField.getText(), getSelectedRoomType(), stateField.getText(), Integer.parseInt(bedCountField.getText()), Double.parseDouble(priceField.getText()), wifiCheckBox.isSelected(), tvCheckBox.isSelected(), acCheckBox.isSelected());
                new SaveRoomInfo(AddRoomWindow.this, room);
                JOptionPane.showMessageDialog(AddRoomWindow.this, "Room added successfully!");
                resetFields();
            }
        });

        JButton resetButton = (JButton) buttonPanel.getComponent(1);
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });

        JButton mainMenuButton = (JButton) buttonPanel.getComponent(2);
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Main_Window().setVisible(true);;  
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(roomNumberField);
        mainPanel.add(createRoomTypePanel());
        mainPanel.add(bedCountField);
        mainPanel.add(priceField);
        mainPanel.add(stateField);
        mainPanel.add(createCheckBoxPanel());

        JPanel buttonContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonContainer.add(buttonPanel);
        mainPanel.add(buttonContainer);
        add(mainPanel);
        setVisible(true);
    }

    private void resetFields() {
        roomNumberField.setText("");
        singleRadio.setSelected(true);
        bedCountField.setText("");
        priceField.setText("");
        wifiCheckBox.setSelected(false);
        tvCheckBox.setSelected(false);
        acCheckBox.setSelected(false);
        stateField.setText("available");
    }

    private JPanel createRoomTypePanel() {
        JPanel roomTypePanel = new JPanel();
        roomTypePanel.add(new JLabel("Room Type:"));
        roomTypePanel.add(singleRadio);
        roomTypePanel.add(doubleRadio);
        roomTypePanel.add(suiteRadio);
        roomTypePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        singleRadio.setSelected(true);
        return roomTypePanel;
    }

    private JPanel createCheckBoxPanel() {
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.add(wifiCheckBox);
        checkBoxPanel.add(tvCheckBox);
        checkBoxPanel.add(acCheckBox);
        checkBoxPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        return checkBoxPanel;
    }

    private String getSelectedRoomType() {
        if (singleRadio.isSelected()) {
            return "Single";
        } else if (doubleRadio.isSelected()) {
            return "Double";
        } else if (suiteRadio.isSelected()) {
            return "Suite";
        }
        return null;
    }

//    private void saveRoomInfo(Room room) {
//        try (FileWriter fw = new FileWriter("infoRooms.txt", true)) {
//            fw.write(room.toString());
//            try(FileWriter fw1 = new FileWriter("tempInfoRooms.txt",true)){
//            	fw1.write(room.toString());
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error saving room information.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }

    public static void main(String[] args) {
        new AddRoomWindow();
    }
}
