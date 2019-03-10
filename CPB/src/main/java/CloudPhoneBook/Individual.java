package CloudPhoneBook;

import com.google.gson.Gson;
import org.springframework.data.annotation.Id;

public class Individual extends User {
    @Id
    private String id;

    private int INIPA;

    public Individual() {}

    public Individual(String name, String phone, int INIPA) {
        super(name, phone);
        setINIPA(INIPA);
    }

    public int getINIPA() {
        return INIPA;
    }

    public void setINIPA(int INIPA) {
        this.INIPA = INIPA;
    }

    public String toString() {
        return super.getName() + " " +
                super.getPhone() + " " +
                getINIPA();
    }

    public String toCSV() {
        return this.getName() + "," +
                this.getPhone() + "," +
                this.getINIPA();
    }

    public void fromCSV(String str) {
        String[] strings = str.split(",");
        setName(strings[0]);
        setPhone(strings[1]);
        setINIPA(Integer.valueOf(strings[2]));
    }

    public String toJSON() {
        return new Gson().toJson(this);
    }

    public static Individual fromJSON(String json) {
        return new Gson().fromJson(json, Individual.class);
    }
}