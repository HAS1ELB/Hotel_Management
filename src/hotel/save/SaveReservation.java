package hotel.save;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import hotel.beans.Reservation;

public class SaveReservation {
	public SaveReservation(JFrame f, Reservation r) {
		try (FileWriter reservationInfoWriter = new FileWriter("Data_Base/ReservationInfo.txt", true)) {
            reservationInfoWriter.write(r.toString());
            reservationInfoWriter.write("\n=====================================================");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(f, "Error writing to ReservationInfo.txt file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
	}
}
