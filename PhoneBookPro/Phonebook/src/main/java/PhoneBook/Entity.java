package PhoneBook;

public class Entity extends User {
    private int TIN; // ИНН

    public Entity() {
        super("", "");
        setTIN(0);
    }

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

    public String toCSV() {
        return this.getSNP() + ";" + this.getPhone() + ";" + this.getTIN();
    }

    public void fromCSV(String str) {
        String[] strings = str.split(";");
        setSNP(strings[0]);
        setPhone(strings[1]);
        setTIN(Integer.valueOf(strings[2]));
    }
}