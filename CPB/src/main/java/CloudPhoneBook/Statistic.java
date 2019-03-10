package CloudPhoneBook;

import java.util.ArrayList;

public class Statistic {
    ArrayList<Call> calls;
    ArrayList<Conference> conferences;

    public Statistic(ArrayList<Call> calls, ArrayList<Conference> conferences) {
        this.calls = calls;
        this.conferences = conferences;
    }

    static public int During(int... times) {
        int reduce = 0;

        for (int time : times) {
            reduce += time;
        }

        return reduce;
    }

    public long getTotalDuring() {
        final long[] totalTime = {0, 0};

        Runnable runCalls = () -> {
            totalTime[0] += getTotalDuringCalls();
        };

        Thread threadRunCalls = new Thread(runCalls);
        threadRunCalls.start();

        totalTime[1] += getTotalDuringConference();

        try {
            threadRunCalls.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return totalTime[0] + totalTime[1];
    }

    public long getTotalDuringCalls() {
        if (calls == null) {
            throw new NullPointerException();
        }

        long total = 0;
        for (Call call : calls) {
            total += call.getTime();
        }
        return total;
    }

    public long getTotalDuringConference() {
        if (conferences == null) {
            throw new NullPointerException();
        }

        long total = 0;
        for (Conference conference : conferences) {
            total += conference.getTime();
        }
        return total;
    }

    public long getTotalDuringTimeByUser(User user) {
        long total = 0;

        for (Call call : calls) {
            if (user.getName().equals(call.getCgpn()) || user.getName().equals(call.getCgpn())) {
                total += call.getTime();
            }
        }

        for (Conference conference : conferences) {
            for (User tUser : conference.getUsers()) {
                if (user.getName().equals(tUser.getName())) {
                    total += conference.getTime();
                }
            }
        }

        return total;
    }
}