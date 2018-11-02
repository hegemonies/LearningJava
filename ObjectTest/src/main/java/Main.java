import User.*;

public class Main {
    public static void main(String[] args) {
        Object object = new User("Ivanov", "+5 555 595", 5976255);

        User user = (User) object;
        System.out.println(user.toString());
    }
}
