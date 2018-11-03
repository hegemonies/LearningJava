package PhoneBook;

public class Entity extends User {
    private int TIN; // ИНН
    private String address;
    private int CRR; // КПП
    private long capital; // уставной капитал

    public Entity(String SNP, String phone, int TIN, int CRR, long capital) {
        super("", "");
        setTIN(0);
    }

    public Entity(String SNP, String phone, int TIN, String address, int CRR, int capital) {
        super(SNP, phone);
        this.setTIN(TIN);
        this.setAddress(address);
        this.setCRR(CRR);
        this.setCapital(capital);
    }

    public int getTIN() {
        return TIN;
    }

    public void setTIN(int TIN) {
        this.TIN = TIN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCRR() {
        return CRR;
    }

    public void setCRR(int CRR) {
        this.CRR = CRR;
    }

    public long getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String toString() {
        return (super.getSNP()
                + "\t" + super.getPhone()
                + "\t\t" + getTIN()
                + "\t" + getAddress()
                + "\t" + getCRR()
                + "\t" + getCapital());
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