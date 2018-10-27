import phonebook.*;

public class Main {
    private static PhoneBook pb = new PhoneBook();

    public static void main(String[] args) throws Exception {
        try {
            pb.AddUser("Ivanov Ivan", "+1 662 1617 8238", 8554354);
            pb.AddUser("Maximov Maxim", "+1 123 345 6789", 772722);
            pb.AddUser("Lojkarev Oleg", "+1 533 777 2521", 262772);
            pb.AddUser("Petrov Petr", "+1 222 463 1177", 63636367);
            pb.AddUser("Hugo Ben", "+1 123 717 4444", 2626784);
        } catch (Exception exc) {
            System.out.println("Error: " + exc.getMessage());
        }

        pb.printList();
    }
}
