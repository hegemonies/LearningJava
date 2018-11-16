package PhoneBook;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Statistic {
    static public int During(int... times) {
        int reduce = 0;

        for (int time : times) {
            reduce += time;
        }

        return reduce;
    }
/*
    public long totalDuring(ArrayList<Call> calls, ArrayList<Conference> conferences) {
        AtomicLong total = new AtomicLong();

//        Lock lock = new ReentrantLock();
        Runnable runCalls = () -> {
//            lock.lock();
            try {
                total.addAndGet(totalDuringCalls(calls));
            } catch (NullPointerException exc) {
                System.out.println("Error: " + exc.getMessage());
            } finally {
//                lock.unlock();
            }
        };

        new Thread(runCalls).start();
        total.addAndGet(totalDuringConference(conferences));

        return total.get();
    }
*/
    public long totalDuring(ArrayList<Call> calls, ArrayList<Conference> conferences) {
        long total = 0;
        try {
            total += totalDuringCalls(calls);
            total += totalDuringConference(conferences);
        } catch (NullPointerException exc) {
            System.out.println("Error: " + exc.getMessage());
        }
        return total;
    }

    public long totalDuringCalls(ArrayList<Call> calls) {
        if (calls == null) {
            throw new NullPointerException();
        }

        long total = 0;
        for (Call call : calls) {
            total += call.getTime();
        }
        return total;
    }

    public long totalDuringConference(ArrayList<Conference> conferences) {
        if (conferences == null) {
            throw new NullPointerException();
        }

        long total = 0;
        for (Conference conference : conferences) {
            total += conference.getTime();
        }
        return total;
    }
}
