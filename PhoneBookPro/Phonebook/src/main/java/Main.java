import PhoneBook.*;
import CSV.*;

public class Main {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();

        pb.AddIndividual("Han Solovich", "+5 555 955 9945", 555759);
        pb.AddIndividual("Maximov Maxim", "+1 123 345 6789", 772722);
//        pb.AddUser("Lojkarev Oleg", "+1 533 777 2521", 262772);
//        pb.AddUser("Siloviki.ru", "+5 226 789 5645", 9976022);
//        pb.AddUser("Stolary.ru", "+9 956 978 5564", 54069978, 0, 10000000);
//        pb.AddUser("Petrovich Petr", "+1 222 463 1177", 63636367);
        pb.AddEntity("Super Magazin", "+1 123 717 4444", 2626784, "agag", 544551, 1000000);

        pb.PhoneBookToFile("test.txt");

        PhoneBook pb1 = new PhoneBook();
        pb1.PhoneBookFromFile("test.txt");
        pb1.ShowAllUsers();

//        pb.ShowTotalDuringCalls();

//        pb.ShowTotalDuringCallsByAllUsers();

        for (int i = 0; i < 10; i++) {
            pb.addCall(i, new Individual("a", "b", 0), new Individual("a", "b", 0), "afaf");
        }

        for (int i = 0; i < 10; i++) {
            Individual[] individuals = new Individual[2];
            individuals[0] = new Individual("a", "b", 0);
            individuals[1] = new Individual("c", "d", 1);
            pb.addConference(i, individuals, "afaf");
        }

        System.out.println("Calls:");
        pb.ShowCalls();
        System.out.println("\nConference:");
        pb.ShowConferences();

        pb.CallsToFile("Calls.csv");
        pb.ConferenceToFile("Conference.csv");
    }
}

