package hotel.beans;

public class Room {
	
	private String number;
	private String type;
	private String state;
	private int bedCount;
	private double price;
	private boolean wifi;
	private boolean tv;
	private boolean ac;
	
	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isAc() {
		return ac;
	}

	public void setAc(boolean ac) {
		this.ac = ac;
	}

	public Room() {
	}

	public Room(String number, String type, String state, int bedCount, double price, boolean wifi, boolean tv, boolean ac) {
		this.number = number;
		this.type = type;
		this.state = state;
		this.bedCount = bedCount; 
		this.price = price;
		this.wifi = wifi;
		this.tv = tv;
		this.ac = ac;
	}

	public int getBedCount() {
		return bedCount;
	}

	public void setBedCount(int bedCount) {
		this.bedCount = bedCount;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return  number + "\n" +
                type + "\n" +
                bedCount+ "\n" +
                price + "\n" +
                wifi + "\n" +
                tv + "\n" +
                ac + "\n" +
                state + "\n" + 
                "======================\n";

	}
 
	public boolean equals(Room obj) {
		return (number.equals(obj.number));
	}
}
