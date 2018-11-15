package PhoneBook;
import CSV.*;

abstract class User implements CSV, Comparable<User> {
    private String Name;
    private String phone;

    public User(String Name, String phone) {
        setName(Name);
        setPhone(phone);
    }

    public String getName() {
        return Name;
    }

    public void setName(String SNP) {
        this.Name = SNP;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String toString() {
        return getName() + " " + getPhone();
    }

    public int compareTo(User user) {
        return Name.compareTo(user.getName());
    }
}
