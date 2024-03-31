package hotel.save;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import hotel.beans.Room;

public class SaveRoomInfo {
	public SaveRoomInfo(JFrame f,Room r) {
		try (FileWriter fw = new FileWriter("Data_Base/infoRooms.txt", true)) {
            fw.write(r.toString());
            fw.close();
            try(FileWriter fw1 = new FileWriter("Data_Base/tempInfoRooms.txt",true)){
            	fw1.write(r.toString());
            	fw1.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(f,"Error saving room information.", "Error", JOptionPane.ERROR_MESSAGE);
        }
	}
}
