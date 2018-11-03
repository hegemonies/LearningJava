import PhoneBook.*;
import CSV.*;

public class Main {
    public static void main(String[] args) {
//        Entity entity = new Entity("Han Solo", "+5 555 955", 555759);
//
//        Individual individual = new Individual("Solo Han", "+9 667 882", 9986657);
//
//        System.out.println("Entity:\t\t" + entity.toString());
//        System.out.println("Individual:\t" + individual.toString());

//        System.out.println(entity.toCSV());
//        entity.fromCSV(entity.toCSV());

        PhoneBook pb = new PhoneBook();

        pb.AddUser("Han Solovich", "+5 555 955 9945", 555759);
        pb.AddUser("Maximov Maxim", "+1 123 345 6789", 772722);
        pb.AddUser("Lojkarev Oleg", "+1 533 777 2521", 262772);
        pb.AddUser("Siloviki.ru", "+5 226 789 5645", 9976022);
        pb.AddUser("Stolary.ru", "+9 956 978 5564", 54069978, 0, 10000000);
        pb.AddUser("Petrovich Petr", "+1 222 463 1177", 63636367);
        pb.AddUser("Hugo Benedict", "+1 123 717 4444", 2626784);

        pb.Show();
    }


}

