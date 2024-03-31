package hotel.beans;

public class Client {
    private String lastName;
    private String firstName;
    private int age;
    private String address;
    private int contact;
    private String idNumber;

    public Client() {
        this.lastName = "";
        this.firstName = "";
        this.age = 0;
        this.address = "";
        this.contact = 0;
        this.idNumber = "";
    }

    public Client(String lastName, String firstName, int age, String address, int contact, String idNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.address = address;
        this.contact = contact;
        this.idNumber = idNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "\n\tLast Name: " + lastName + "\n" +
                "\tFirst Name: " + firstName + "\n" +
                "\tAge: " + age + "\n" +
                "\tAddress: " + address + "\n" +
                "\tContact: " + contact + "\n" +
                "\tID Number: " + idNumber;
    }
}
