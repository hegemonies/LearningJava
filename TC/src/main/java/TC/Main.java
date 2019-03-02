package TC;

import java.util.*;

public class Main {
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static LinkedList<Integer> linkedList = new LinkedList<>();
    static TreeSet<Integer> treeSet = new TreeSet<>();
    static HashSet<Integer> hashSet = new HashSet<>();
    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String... args) {

        new Thread(() -> {
            double elapsedTime = 0;
            elapsedTime -= System.nanoTime();

            for (int i = 0; i < 1000000; i++) {
                arrayList.add(i);
            }

            elapsedTime += System.nanoTime();
            System.out.println("Elapsed time of array list = " + (elapsedTime / Math.pow(10, 9)) + " sec");
        }).start(); // array list

        new Thread(() -> {
            double elapsedTime = 0;
            elapsedTime -= System.nanoTime();

            for (int i = 0; i < 1000000; i++) {
                linkedList.add(i);
            }

            elapsedTime += System.nanoTime();
            System.out.println("Elapsed time of linked list = " + (elapsedTime / Math.pow(10, 9)) + " sec");
        }).start(); // linked list

        new Thread(() -> {
            double elapsedTime = 0;
            elapsedTime -= System.nanoTime();

            for (int i = 0; i < 1000000; i++) {
                treeSet.add(i);
            }

            elapsedTime += System.nanoTime();
            System.out.println("Elapsed time of tree set = " + (elapsedTime / Math.pow(10, 9)) + " sec");
        }).start(); // tree set

        new Thread(() -> {
            double elapsedTime = 0;
            elapsedTime -= System.nanoTime();

            for (int i = 0; i < 1000000; i++) {
                hashSet.add(i);
            }

            elapsedTime += System.nanoTime();
            System.out.println("Elapsed time of hash set = " + (elapsedTime / Math.pow(10, 9)) + " sec");
        }).start(); // hash set

        new Thread(() -> {
            double elapsedTime = 0;
            elapsedTime -= System.nanoTime();

            for (int i = 0; i < 1000000; i++) {
                treeMap.put(i, i);
            }

            elapsedTime += System.nanoTime();
            System.out.println("Elapsed time of tree map = " + (elapsedTime / Math.pow(10, 9)) + " sec");
        }).start(); // tree map

        new Thread(() -> {
            double elapsedTime = 0;
            elapsedTime -= System.nanoTime();

            for (int i = 0; i < 1000000; i++) {
                hashMap.put(i, i);
            }

            elapsedTime += System.nanoTime();
            System.out.println("Elapsed time of hash map = " + (elapsedTime / Math.pow(10, 9)) + " sec");
        }).start(); // hash map
    }
}