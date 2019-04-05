package PhoneBook;

import com.google.gson.Gson;

/**
 * Subclass present a individuals
 * @author hegemonies <hegemonies@yandex.ru></hegemonies@yandex.ru>
 * @version 1.0.0
 */
public class Individual extends User {
    private int INIPA; //

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
        return super.getName() + " " +
                super.getPhone() + " " +
                getINIPA();
    }

    /**
     * Сonverts object fields to CSV format
     * @return converted string
     */
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
