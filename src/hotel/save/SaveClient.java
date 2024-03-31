package hotel.save;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import hotel.beans.Client;

public class SaveClient {
	public SaveClient(JFrame f, Client c) {
		try (FileWriter clientInfoWriter = new FileWriter("Data_Base/clientInfo.txt", true);) {
        	clientInfoWriter.write(c.toString());
            clientInfoWriter.write("\n=====================================================");
            clientInfoWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(f, "Error writing to ReservationInfo.txt file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
		
		
	}
} 
