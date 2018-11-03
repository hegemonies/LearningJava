package PhoneBook;

import java.util.ArrayList;

public class PhoneBook {
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Call> calls = new ArrayList<>();
    ArrayList<Conference> conferences = new ArrayList<>();
    Statistic statistic = new Statistic();

    public void AddUser(String SNP, String phone, int INIPA) {
        users.add(new Individual(SNP, phone, INIPA));
    }

    public void AddUser(String SNP, String phone, int TIN, int CRR, long capital) {
        users.add(new Entity(SNP, phone, TIN, CRR, capital));
    }

    public void DeleteUser(String SNPorPhone) {
        ArrayList<User> forDelete = new ArrayList<>();

        for (User user : users) {
            if (user.getSNP().equals(SNPorPhone)) {
                forDelete.add(user);
            }
        }

        users.remove(forDelete.get(0));
    }

    public void Show() {
        System.out.println("SNP \t\t\tPhone   \t\t\tTIN");
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}

