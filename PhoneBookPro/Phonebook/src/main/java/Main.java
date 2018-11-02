import PhoneBook.*;

public class Main {
    public static void main(String[] args) {
        Entity entity = new Entity("Han Solo", "+5 555 955", 555759);

        Individual individual = new Individual("Solo Han", "+9 667 882", 9986657);

        System.out.println("Entity:\t\t" + entity.toString());
        System.out.println("Individual:\t" + individual.toString());
    }
}
