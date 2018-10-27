package phonebook;

import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<User> phBook = new ArrayList<>();

    public void AddUser(String _SNP, String _phone, int _TIN) throws Exception {
        if (!phBook.add(new User(_SNP, _phone, _TIN))) {
            throw new Exception("Exception PhoneBook: Error adding");
        }
    }

    public void DeleteUser(String SNPorPhone) {
        if (SNPorPhone.substring(0, 1).equals("+")) {
            for (User user : phBook) {
                if (user.getPhone().equals(SNPorPhone)) {
                    phBook.remove(user);
                }
            }
        } else {
            for (User user : phBook) {
                if (user.getSNP().equals(SNPorPhone)) {
                    phBook.remove(user);
                }
            }
        }
    }

    public void DeleteUser(int TIN) {
        for (User user : phBook) {
            if (user.getTIN() == TIN) {
                phBook.remove(user);
            }
        }
    }

    public User getUserBySNP(String SNP) {
        for (User user : phBook) {
            if (user.getSNP().equals(SNP)) {
                return user;
            }
        }

        return null;
    }

    public User getUserByPhone(String phone) {
        for (User user : phBook) {
            if (user.getPhone() == phone) {
                return user;
            }
        }

        return null;
    }

    public void printList() {
        System.out.println("SNP\t\t\t\tPhone\tTIN");
        for (User user : phBook) {
//            System.out.println(user.getSNP() + "\t" + user.getPhone() + "\t" + user.getTIN());
            System.out.printf("%s\t\t%s\t%d\n", user.getSNP(), user.getPhone(), user.getTIN());
        }
    }
}
