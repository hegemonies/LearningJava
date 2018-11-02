import CSVReader.*;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(CSVReader.toRead("file.txt"));
        } catch (Exception exc) {
            System.out.println("Error: " + exc.getMessage());
        }
    }
}
