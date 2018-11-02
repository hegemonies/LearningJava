package phonebook;

public class User implements Comparable<User> {
    private String SNP;
    private String phone;
    private int TIN;

    public User(String SNP, String phone, int TIN) {
        setSNP(SNP);
        setPhone(phone);
        setTIN(TIN);
    }

    public int getTIN() {
        return TIN;
    }

    public void setTIN(int TIN) {
        this.TIN = TIN;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSNP() {
        return SNP;
    }

    public void setSNP(String SNP) {
        this.SNP = SNP;
    }

    public int compareTo(User user) {
        return SNP.compareTo(user.getSNP());
    }
}
