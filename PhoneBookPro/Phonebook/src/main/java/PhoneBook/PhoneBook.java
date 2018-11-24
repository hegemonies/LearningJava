package PhoneBook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    private ArrayList<Entity> entities = new ArrayList<>();
    private ArrayList<Individual> individuals = new ArrayList<>();
    private ArrayList<Call> calls = new ArrayList<>();
    private ArrayList<Conference> conferences = new ArrayList<>();
    private Statistic statistic = new Statistic(calls, conferences);

    public void AddEntity(String Name, String phone, int TIN, String address, int CRR, int capital) {
        entities.add(new Entity(Name, phone, TIN, address, CRR, capital));
    }

    public void AddIndividual(String Name, String phone, int INIPA) {
        individuals.add(new Individual(Name, phone, INIPA));
    }

    public void DeleteEntity(String Name) {
        for (Entity entity : entities) {
            if (entity.getName().equals(Name)) {
                entities.remove(entity);
                break;
            }
        }
    }

    public void DeleteIndividual(String Name) {
        for (Individual individual : individuals) {
            if (individual.getName().equals(Name)) {
                individuals.remove(individual);
                break;
            }
        }
    }

    public void ShowAllUsers() {
        ShowEntitys();
        System.out.println();
        ShowIndividuals();
        System.out.println();
    }

    public void ShowEntitys() {
        System.out.println("List of entity's");
        System.out.println("Name\tPhone\tTIN\tAddress\tCRR\tCapital");
        for (Entity entity : entities) {
            System.out.println(entity.toString());
        }
    }

    public void ShowIndividuals() {
        System.out.println("List of individuals");
        System.out.println("Name\tPhone\tINIPA");
        for (Individual individual : individuals) {
            System.out.println(individual.toString());
        }
    }

    public void PhoneBookToFile(String fileName) {
        File file = new File(fileName);

        if (file.exists()) {
            file.delete();
        } else {
            try {
                file.createNewFile();
            } catch (IOException exc) {
                System.out.println("Error creating file: " + exc.getMessage());
            }
        }

        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("Type,Name,Phone,INIPA\n");
            for (Individual individual : individuals) {
                writer.write(TypeUser.Individual + "," + individual.toCSV() + "\n");
            }
            writer.write("Type,Name,Phone,TIN,Address,CRR,Capital\n");
            for (Entity entity : entities) {
                writer.write(TypeUser.Entity + "," + entity.toCSV() + "\n");
            }
        } catch (IOException exc) {
            System.out.println("Error creating file: " + exc.getMessage());
        }
    }

    private void IndividualsToFile(String fileName) {
        File file = new File(fileName);

        if (file.exists()) {
            file.delete();
        } else {
            try {
                file.createNewFile();
            } catch (IOException exc) {
                System.out.println("Error creating file: " + exc.getMessage());
            }
        }

        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("Type,Name,Phone,INIPA\n");
            for (Individual individual : individuals) {
                writer.write(TypeUser.Individual + "," + individual.toCSV() + "\n");
            }
        } catch (IOException exc) {
            System.out.println("Error creating file: " + exc.getMessage());
        }
    }

    private void EntitysToFile(String fileName) {
        File file = new File(fileName);

        if (file.exists()) {
            file.delete();
        } else {
            try {
                file.createNewFile();
            } catch (IOException exc) {
                System.out.println("Error creating file: " + exc.getMessage());
            }
        }

        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("Type,Name,Phone,TIN,Address,CRR,Capital\n");
            for (Entity entity : entities) {
                writer.write(TypeUser.Entity + "," + entity.toCSV() + "\n");
            }
        } catch (IOException exc) {
            System.out.println("Error creating file: " + exc.getMessage());
        }
    }

    public void PhoneBookFromFile(String fileName) { //TOneverDO
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File not found");
        }

        try (FileReader reader = new FileReader(fileName)) {
            char[] buffer = new char[(int)file.length()];
            reader.read(buffer);
            String raw = new String(buffer);
            String[] rows = raw.split("\n");

            if (rows.length < 2) {
                return;
            }

            for (String row : rows) {
                String[] elems = row.split(",");

                if (elems.length < 2) {
                    continue;
                }

                try {
                    if (elems[0].equals("Type")) {
                        continue;
                    } else if (elems[0].equals("Individual")) {
                        individuals.add(new Individual(elems[1], elems[2], Integer.valueOf(elems[3])));
                    } else if (elems[0].equals("Entity")) {
                        entities.add(new Entity(elems[1],
                                elems[2],
                                Integer.valueOf(elems[3]),
                                elems[4],
                                Integer.valueOf(elems[5]),
                                Integer.valueOf(elems[6])));
                    }
                } catch (Exception exc) {
                    System.out.println("Error: " + exc.getMessage());
                }
            }
        } catch (IOException exc) {
            System.out.println("Error reading file: " + exc.getMessage());
        }
    }

    public void CallsToFile(String fileName) {
        if (Files.exists(Paths.get(fileName))) {
            try {
                Files.delete(Paths.get(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Files.createFile(Paths.get(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("Time,CGPN,CDPN,Description\n");
            for (Call call : calls) {
                writer.write(call.toCSV() + "\n");
            }
        } catch (IOException exc) {
            System.out.println("Error creating file: " + exc.getMessage());
        }
    }

    public void ConferenceToFile(String fileName) {
        if (Files.exists(Paths.get(fileName))) {
            try {
                Files.delete(Paths.get(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Files.createFile(Paths.get(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("Time,Users,Description\n");
            for (Conference conference : conferences) {
                writer.write(conference.toCSV() + "\n");
            }
        } catch (IOException exc) {
            System.out.println("Error creating file: " + exc.getMessage());
        }
    }

    public void ShowCalls() {
        System.out.println("Time,CGPN,CDPN,Description");
        for (Call call : calls) {
            System.out.println(call.toCSV());
        }
    }

    public void ShowConferences() {
        System.out.println("Time,Users,Description");
        for (Conference conference : conferences) {
            System.out.println(conference.toCSV());
        }
    }

    public void addCall(int Time, User cgpn, User cdpn, String description) {
        calls.add(new Call(Time, cgpn, cdpn, description));
    }

    public void addConference(int Time, User[] users, String description) {
        conferences.add(new Conference(Time, users, description));
    }

    public void ShowTotalDuringCalls() {
        System.out.println("Total During = " + statistic.getTotalDuring());
    }

    public void ShowTotalDuringCallsByAllUsers() {
        System.out.println("\nList of entity's");
        System.out.println("Name\tPhone\tTIN\tAddress\tCRR\tCapital");
        for (Entity entity : entities) {
            System.out.println(entity.toString() + " " + statistic.getTotalDuringTimeByUser(entity));
        }

        System.out.println("\nList of individuals");
        System.out.println("Name\tPhone\tINIPA");
        for (Individual individual : individuals) {
            System.out.println(individual.toString() + " " + statistic.getTotalDuringTimeByUser(individual));
        }
    }

    public long getTotalDuringTimesAllCalls() {
        return statistic.getTotalDuring();
    }

    public long getDuringByUser(User user) {
        return statistic.getTotalDuringTimeByUser(user);
    }

    public long getSize(String fileName) {
        try {
            return Files.size(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void Backup() {
        Scanner scanner = new Scanner(System.in);

        String toEntitys = scanner.next();
        String toIndividuals = scanner.next();

        this.EntitysToFile(toEntitys);
        this.IndividualsToFile(toIndividuals);
    }
}