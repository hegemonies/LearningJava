package CloudPhoneBook;

import com.google.gson.*;

public class LegalEntity extends User {
    private static int id;
    private int TIN; //
    private String address;
    private int CRR; //
    private long capital; //

    public LegalEntity(String Name, String phone, int TIN, String address, int CRR, int capital) {
        super(Name, phone);
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

    public void setCapital(long capital) {
        this.capital = capital;
    }

    public String toString() {
        return (super.getName()
                + " " + super.getPhone()
                + " " + getTIN()
                + " " + getAddress()
                + " " + getCRR()
                + " " + getCapital());
    }

    public String toCSV() {
        return this.getName() + "," +
                this.getPhone() + "," +
                this.getTIN() + "," +
                this.getAddress() + "," +
                this.getCRR()  + "," +
                this.getCapital();
    }

    public void fromCSV(String str) {
        String[] strings = str.split(",");
        if (strings.length < 6) {
            return;
        }

        setName(strings[0]);
        setPhone(strings[1]);
        setTIN(Integer.valueOf(strings[2]));
        setAddress(strings[3]);
        setCRR(Integer.valueOf(strings[4]));
        setCapital(Long.valueOf(strings[5]));
    }

    public String toJSON() {
        return new Gson().toJson(this);
    }

    public static LegalEntity fromJSON(String json) {
        return new Gson().fromJson(json, LegalEntity.class);
    }
}