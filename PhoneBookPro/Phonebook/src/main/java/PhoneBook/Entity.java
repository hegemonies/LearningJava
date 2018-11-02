package PhoneBook;

public class Entity extends User {
    private int TIN; // ИНН

    public Entity(String SNP, String phone, int TIN) {
        super(SNP, phone);
        this.setTIN(TIN);
    }

    public int getTIN() {
        return TIN;
    }

    public void setTIN(int TIN) {
        this.TIN = TIN;
    }

    public String toString() {
        return (super.getSNP() + "\t" + super.getPhone() + "\t" + getTIN());
    }
}
