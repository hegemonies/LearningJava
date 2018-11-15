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
        return (super.getName() + "\t\t\t\t" + super.getPhone() + "\t\t" + getINIPA());
    }

    public String toCSV() {
        return this.getName() + ";" + this.getPhone() + ";" + this.getINIPA();
    }

    public void fromCSV(String str) {
        String[] strings = str.split(";");
        setName(strings[0]);
        setPhone(strings[1]);
        setINIPA(Integer.valueOf(strings[2]));
    }
}
