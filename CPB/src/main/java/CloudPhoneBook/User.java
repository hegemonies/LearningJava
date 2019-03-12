package CloudPhoneBook;

import CSV.*;

abstract class User implements CSV, Comparable<User> {
    private String Name;
    private String Phone;

    public User() {}

    public User(String Name, String Phone) {
        setName(Name);
        setPhone(Phone);
    }

    public String getName() {
        return Name;
    }

    public void setName(String SNP) {
        this.Name = SNP;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getPhone() {
        return Phone;
    }

    public String toString() {
        return getName() + " " + getPhone();
    }

    public String toCSV() {
        return getName() + "," + getPhone();
    }

    public int compareTo(User user) {
        return Name.compareTo(user.getName());
    }
}
