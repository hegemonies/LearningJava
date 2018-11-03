package PhoneBook;

public class Statistic {
    static public int During(int... times) {
        int reduce = 0;

        for (int time : times) {
            reduce += time;
        }

        return reduce;
    }
}
