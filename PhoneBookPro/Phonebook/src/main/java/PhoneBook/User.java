package PhoneBook;

abstract class User {
    private String SNP; // ФИО
    private String phone;

    public User(String SNP, String phone) {
        setSNP(SNP);
        setPhone(phone);
    }

    public String getSNP() {
        return SNP;
    }

    public void setSNP(String SNP) {
        this.SNP = SNP;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
