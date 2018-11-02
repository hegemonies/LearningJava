package PhoneBook;

public class Individual extends User {
    private int INIPA; // СНИЛС

    public Individual(String SNP, String phone, int INIPA) {
        super(SNP, phone);
        setINIPA(INIPA);
    }

    public int getINIPA() {
        return INIPA;
    }

    public void setINIPA(int INIPA) {
        this.INIPA = INIPA;
    }

    public String toString() {
        return (super.getSNP() + "\t" + super.getPhone() + "\t" + getINIPA());
    }
}
