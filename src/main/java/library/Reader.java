package library;

public class Reader {
    private static int id = 10000;
    private int readerID;
    private String fullName, address, phoneNumber, specialization;

    public Reader(int readerID, String fullName, String address, String phoneNumber, String specialization) {
        if (readerID == 0) {
            this.readerID = id++;
        }
        else {
            this.readerID = readerID;
        }
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
    }

    public Reader() {

    }

    public Reader(int readerID) {
        this.readerID = readerID;
    }

    public int getReaderID() {
        return readerID;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerID=" + readerID +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
