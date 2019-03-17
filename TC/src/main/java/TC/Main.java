package TC;

import java.util.*;

public class Main {
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static LinkedList<Integer> linkedList = new LinkedList<>();
    static TreeSet<Integer> treeSet = new TreeSet<>();
    static HashSet<Integer> hashSet = new HashSet<>();
    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    static int size = 1000000;

    public static void main(String... args) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        goParallel();
//        goSerial();
    }

    private static void goParallel() {
        new Thread(() -> {
            double elapsedTime = 0;
            elapsedTime -= System.nanoTime();

            for (int i = 0; i < size; i++) {
                arrayList.add(i);
            }

            elapsedTime += System.nanoTime();
            System.out.println("Elapsed time of array list = " + (elapsedTime / Math.pow(10, 9)) + " sec");

            arrayList.clear();
        }).start(); // array list

        new Thread(() -> {
            double elapsedTime = 0;
            elapsedTime -= System.nanoTime();

            for (int i = 0; i < size; i++) {
                linkedList.add(i);
            }

            elapsedTime += System.nanoTime();
            System.out.println("Elapsed time of linked list = " + (elapsedTime / Math.pow(10, 9)) + " sec");
            linkedList.clear();
        }).start(); // linked list

        new Thread(() -> {
            double elapsedTime = 0;
            elapsedTime -= System.nanoTime();

            for (int i = 0; i < size; i++) {
                treeSet.add(i);
            }

            elapsedTime += System.nanoTime();
            System.out.println("Elapsed time of tree set = " + (elapsedTime / Math.pow(10, 9)) + " sec");
            treeSet.clear();
        }).start(); // tree set

        new Thread(() -> {
            double elapsedTime = 0;
            elapsedTime -= System.nanoTime();

            for (int i = 0; i < size; i++) {
                hashSet.add(i);
            }

            elapsedTime += System.nanoTime();
            System.out.println("Elapsed time of hash set = " + (elapsedTime / Math.pow(10, 9)) + " sec");
            hashSet.clear();
        }).start(); // hash set

        new Thread(() -> {
            double elapsedTime = 0;
            elapsedTime -= System.nanoTime();

            for (int i = 0; i < size; i++) {
                treeMap.put(i, i);
            }

            elapsedTime += System.nanoTime();
            System.out.println("Elapsed time of tree map = " + (elapsedTime / Math.pow(10, 9)) + " sec");
            treeMap.clear();
        }).start(); // tree map

        new Thread(() -> {
            double elapsedTime = 0;
            elapsedTime -= System.nanoTime();

            for (int i = 0; i < size; i++) {
                hashMap.put(i, i);
            }

            elapsedTime += System.nanoTime();
            System.out.println("Elapsed time of hash map = " + (elapsedTime / Math.pow(10, 9)) + " sec");
            hashMap.clear();
        }).start(); // hash map
    }

    private static void goSerial() {
        double elapsedTime = 0;

        elapsedTime -= System.nanoTime();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }

        elapsedTime += System.nanoTime();

        arrayList.clear();

        System.out.println("Elapsed time for the method of adding a array list = " + (elapsedTime / Math.pow(10, 9)) + " sec");

        elapsedTime = 0;
        elapsedTime -= System.nanoTime();

        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }

        elapsedTime += System.nanoTime();

        linkedList.clear();

        System.out.println("Elapsed time for the method of adding a linked list = " + (elapsedTime / Math.pow(10, 9)) + " sec");

        elapsedTime = 0;
        elapsedTime -= System.nanoTime();

        for (int i = 0; i < size; i++) {
            treeSet.add(i);
        }

        elapsedTime += System.nanoTime();

        treeSet.clear();

        System.out.println("Elapsed time for the method of adding a tree set = " + (elapsedTime / Math.pow(10, 9)) + " sec");

        elapsedTime = 0;
        elapsedTime -= System.nanoTime();

        for (int i = 0; i < size; i++) {
            hashSet.add(i);
        }

        elapsedTime += System.nanoTime();

        hashSet.clear();

        System.out.println("Elapsed time for the method of adding a hash set = " + (elapsedTime / Math.pow(10, 9)) + " sec");

        elapsedTime = 0;
        elapsedTime -= System.nanoTime();

        for (int i = 0; i < size; i++) {
            treeMap.put(i, i);
        }

        elapsedTime += System.nanoTime();

        treeMap.clear();

        System.out.println("Elapsed time for the method of adding a tree map = " + (elapsedTime / Math.pow(10, 9)) + " sec");

        elapsedTime = 0;
        elapsedTime -= System.nanoTime();

        for (int i = 0; i < size; i++) {
            hashMap.put(i, i);
        }

        elapsedTime += System.nanoTime();

        hashMap.clear();

        System.out.println("Elapsed time for the method of adding a hash map = " + (elapsedTime / Math.pow(10, 9)) + " sec");
    }
}