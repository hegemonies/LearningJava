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

//        pb.ShowAll();

        pb.toFile("test.txt");

        PhoneBook pb1 = new PhoneBook();
        pb1.fromFile("test.txt");
        pb1.ShowAll();
    }
}

