package PhoneBook;

//import com.google.gson.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LegalEntity extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private static Integer id = 0;
    private int TIN; // Taxpayer Identification Number
    private String address;
    private int CRR; // Capital Requirements Regulation
    private long capital; //

    public LegalEntity() {
    }

    public LegalEntity(String Name, String phone, int TIN, String address, int CRR, int capital) {
        super(Name, phone);
        this.setTIN(TIN);
        this.setAddress(address);
        this.setCRR(CRR);
        this.setCapital(capital);
        id++;
    }

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        LegalEntity.id = id;
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
/*
    public String toJSON() {
        return new Gson().toJson(this);
    }

    public static Entity fromJSON(String json) {
        return new Gson().fromJson(json, Entity.class);
    }
*/
}