import phonebook.*;

import java.util.TreeSet;

public class Main {
    private static PhoneBook pb = new PhoneBook();

    public static void main(String[] args) {
        System.out.println("ArrayList:");
        double t = 0;
        try {
            t -= System.nanoTime();
            pb.AddUser("Ivanov Ivan", "+1 662 1617 8238", 8554354);
            pb.AddUser("Maximov Maxim", "+1 123 345 6789", 772722);
            pb.AddUser("Lojkarev Oleg", "+1 533 777 2521", 262772);
            pb.AddUser("Petrov Petr", "+1 222 463 1177", 63636367);
            pb.AddUser("Hugo Benedict", "+1 123 717 4444", 2626784);
            t += System.nanoTime();
            System.out.println("Elapsed time adding = " + (t * Math.pow(10, 9)) + " sec");
        } catch (Exception exc) {
            System.out.println("Error: " + exc.getMessage());
        }

        pb.printList();

        System.out.println("Number Ivanov: " + pb.getUserBySNP("Ivanov Ivan").getPhone());
        try {
            pb.DeleteUser("Ivanov Ivan");
//            pb.DeleteUser(8554354);
        } catch (Exception exc) {
            System.out.println("Error: " + exc.getMessage());
        }

        try {
            System.out.println(pb.getUserBySNP("Ivanov Ivan").getPhone());
        } catch (Exception exc) {
            System.out.println("Error: " + exc.getMessage());
        }

//        pb.printList();

        System.out.println("\nTreeSet:");
        TreeSet<User> users = new TreeSet<>();
        t = 0;
        try {
            t -= System.nanoTime();
            users.add(new User("Ivanov Ivan", "+1 662 117 8238", 8554354));
            users.add(new User("Maximov Maxim", "+1 123 345 6789", 772722));
            users.add(new User("Lojkarev Oleg", "+1 533 777 2521", 262772));
            users.add(new User("Petrov Petr", "+1 222 463 1177", 63636367));
            users.add(new User("Hugo Benedict", "+1 123 717 4444", 2626784));
            t += System.nanoTime();
            System.out.println("Elapsed time adding = " + (t * Math.pow(10, 9)) + " sec");
        } catch (Exception exc) {
            System.out.println("Error: " + exc.getMessage());
        }

        System.out.println("SNP \t\t\tPhone   \t\t\tTIN");
        for (User user : users) {
            System.out.println(user.getSNP() + " \t" + user.getPhone() + "\t\t" + user.getTIN());
        }
    }
}
