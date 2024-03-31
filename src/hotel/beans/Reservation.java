package hotel.beans;

public class Reservation {
	
    private int reservationNumber = 0;
    private Client client;
    private int roomNumber;
    private Date date;
    private int durationInDays;
    private double price;
    private String paymentMethod;

    public Reservation() {
    }

    public Reservation(Client client, int roomNumber, Date date, int durationInDays, double price) {
        this.client = client;
        this.roomNumber = roomNumber;
        this.date = date;
        this.durationInDays = durationInDays;
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String toString() {
        return "\nReservation: \n Reservation Number = " + getReservationNumber() +
                "\n Client = " + client +
                "\n Room Number = " + roomNumber +
                "\n Date = " + date +
                "\n Duration of Stay = " + durationInDays +
                "\n Price = " + price +" Dhs"+
                "\n Payment Method = " + paymentMethod;
    }
}
