package hotel.swing;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class RoomResultWindow extends JFrame {

    private LabeledTextField chosenRoomTextField;
    public RoomResultWindow(String roomType, int bedCount, boolean wifi, boolean tv, boolean ac) {
        setTitle("SEARCH ROOM RESULT");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        String result = loadResults(roomType, bedCount, wifi, tv, ac);

        if (result.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No room matches the search criteria.", "No Result", JOptionPane.INFORMATION_MESSAGE);
            new SearchRoom();
        } else {
            chosenRoomTextField = new LabeledTextField("Chosen Room:", 10, 100);

            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            infoPanel.add(chosenRoomTextField);

            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.add(infoPanel, BorderLayout.NORTH);

            JTextArea resultTextArea = new JTextArea(result);
            resultTextArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(resultTextArea);
            mainPanel.add(scrollPane, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton nextButton = new JButton("Next");
            JButton backButton = new JButton("Back");

            nextButton.addActionListener(e -> {
                String chosenRoom = chosenRoomTextField.getText();
                String price = getPriceForRoom(chosenRoom);
                updateRoomState(chosenRoom);
                saveReservation(chosenRoom, price);
                JOptionPane.showMessageDialog(this, "Room saved", "Info", JOptionPane.INFORMATION_MESSAGE);
                new Payment();
                dispose();
            });

            backButton.addActionListener(e -> {
                new SearchRoom();
                dispose();
            });

            buttonPanel.add(nextButton);
            buttonPanel.add(backButton);
            mainPanel.add(buttonPanel, BorderLayout.SOUTH);

            add(mainPanel);

            setVisible(true);
        }
    }

    private void saveReservation(String chosenRoom, String price) {
        ReservationWindow.reservation.setRoomNumber(Integer.parseInt(chosenRoom));
        ReservationWindow.reservation.setPrice(Double.parseDouble(price));
    }

    private void updateRoomState(String roomNumber) {
        String originalFilePath = "Data_Base/infoRooms.txt";
        String tempFilePath = "Data_Base/tempInfoRooms.txt";

        File originalFile = new File(originalFilePath);
        File tempFile = new File(tempFilePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean roomFound = false;

            while ((line = reader.readLine()) != null) {
                if (line.equals(roomNumber)) {
                    roomFound = true;

                    for (int i = 0; i < 7; i++) { // Assuming there are 7 lines for each room
                        writer.write(line);
                        writer.newLine();
                        line = reader.readLine();
                    }

                    writer.write("occupied");
                    writer.newLine();
                } else {
                    writer.write(line);
                    writer.newLine();
                }
            }

            if (!roomFound) {
                System.out.println("Room number not found in the infoRooms.txt file");
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error updating room state.");
        }

        try {
            Files.copy(tempFile.toPath(), originalFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error updating room state.");
        }
    }

    private String loadResults(String roomType, int bedCount, boolean wifi, boolean tv, boolean ac) {
        StringBuilder result = new StringBuilder();
        boolean firstRoom = true;

        try (BufferedReader br = new BufferedReader(new FileReader("Data_Base/infoRooms.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.matches("\\d+")) {
                    String roomTypeFromFile = br.readLine();
                    int bedCountFromFile = Integer.parseInt(br.readLine());
                    double price = Double.parseDouble(br.readLine());
                    boolean hasWifi = Boolean.parseBoolean(br.readLine());
                    boolean hasTV = Boolean.parseBoolean(br.readLine());
                    boolean hasAC = Boolean.parseBoolean(br.readLine());
                    String state = br.readLine();

                    if (roomTypeFromFile.equals(roomType) &&
                            bedCountFromFile == bedCount &&
                            hasWifi == wifi &&
                            hasTV == tv &&
                            hasAC == ac &&
                            state.equals("available")) {
                        if (!firstRoom) {
                            result.append("\n***********************\n");
                        }
                        firstRoom = false;
                        result.append("Room Number: ").append(line).append("\n");
                        result.append("Price: ").append(price).append("\n");
                    }
                } else if (line.equals("======================")) {
                    // Ignore separator lines
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private String getPriceForRoom(String roomNumber) {
        String filePath = "Data_Base/infoRooms.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean roomFound = false;

            while ((line = br.readLine()) != null) {
                if (line.equals(roomNumber)) {
                    roomFound = true;

                    for (int i = 0; i < 3; i++) {
                        line = br.readLine();
                    }

                    return line;
                }
            }
            if (!roomFound) {
                System.out.println("Room number not found in the infoRooms.txt file");
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        new RoomResultWindow("Simple", 4, true, true, true);
    }
}
