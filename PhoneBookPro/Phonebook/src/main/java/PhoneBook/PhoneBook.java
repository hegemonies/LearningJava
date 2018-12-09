package PhoneBook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    private static final Logger log = LogManager.getLogger(PhoneBook.class);

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
        log.info("List of entity's");
        log.info("Name\tPhone\tTIN\tAddress\tCRR\tCapital");
        for (Entity entity : entities) {
            log.info(entity.toString());
        }
    }

    public void ShowIndividuals() {
        log.info("List of individuals");
        log.info("Name\tPhone\tINIPA");
        for (Individual individual : individuals) {
            log.info(individual.toString());
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
                log.error("Error creating file in PhoneBookToFile(): " + exc.getMessage());
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
            log.error("Error open file in PhoneBookToFile(): " + exc.getMessage());
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
                log.error("Error creating file in IndividualsToFile(): " + exc.getMessage());
            }
        }

        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("Type,Name,Phone,INIPA\n");
            for (Individual individual : individuals) {
                writer.write(TypeUser.Individual + "," + individual.toCSV() + "\n");
            }
        } catch (IOException exc) {
            log.error("Error open file in IndividualsToFile(): " + exc.getMessage());
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
                log.error("Error creating file in EntitysToFile(): " + exc.getMessage());
            }
        }

        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("Type,Name,Phone,TIN,Address,CRR,Capital\n");
            for (Entity entity : entities) {
                writer.write(TypeUser.Entity + "," + entity.toCSV() + "\n");
            }
        } catch (IOException exc) {
            log.error("Error open file in EntitysToFile(): " + exc.getMessage());
        }
    }

    public void PhoneBookFromFile(String fileName) {
        File file = new File(fileName);

        if (!file.exists()) {
            log.debug("File not found in PhoneBookFromFile()");
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
                    log.error("Error add user in PhoneBookFromFile(): " + exc.getMessage());
                }
            }
        } catch (IOException exc) {
            log.error("Error open file in PhoneBookFromFile(): " + exc.getMessage());
        }
    }

    public void CallsToFile(String fileName) {
        if (Files.exists(Paths.get(fileName))) {
            try {
                Files.delete(Paths.get(fileName));
            } catch (IOException e) {
                log.info("Error delete file in CallsToFile(): " + e.getMessage());
            }
        } else {
            try {
                Files.createFile(Paths.get(fileName));
            } catch (IOException e) {
                log.info("Error create file in CallsToFile(): " + e.getMessage());
            }
        }

        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("Time,CGPN,CDPN,Description\n");
            for (Call call : calls) {
                writer.write(call.toCSV() + "\n");
            }
        } catch (IOException exc) {
            log.info("Error open file in CallsToFile(): " + exc.getMessage());
        }
    }

    public void ConferenceToFile(String fileName) {
        if (Files.exists(Paths.get(fileName))) {
            try {
                Files.delete(Paths.get(fileName));
            } catch (IOException e) {
                log.info("Error delete file in ConferenceToFile(): " + e.getMessage());
            }
        } else {
            try {
                Files.createFile(Paths.get(fileName));
            } catch (IOException e) {
                log.info("Error create file in ConferenceToFile(): " + e.getMessage());
            }
        }

        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("Time,Users,Description\n");
            for (Conference conference : conferences) {
                writer.write(conference.toCSV() + "\n");
            }
        } catch (IOException exc) {
            log.info("Error open file in ConferenceToFile(): " + exc.getMessage());
        }
    }

    public void ShowCalls() {
        log.info("Time,CGPN,CDPN,Description");
        for (Call call : calls) {
            log.info(call.toCSV());
        }
    }

    public void ShowConferences() {
        log.info("Time,Users,Description");
        for (Conference conference : conferences) {
            log.info(conference.toCSV());
        }
    }

    public void addCall(int Time, User cgpn, User cdpn, String description) {
        calls.add(new Call(Time, cgpn, cdpn, description));
    }

    public void addConference(int Time, User[] users, String description) {
        conferences.add(new Conference(Time, users, description));
    }

    public void ShowTotalDuringCalls() {
        log.info("Total During = " + statistic.getTotalDuring());
    }

    public void ShowTotalDuringCallsByAllUsers() {
        log.info("\nList of entity's");
        log.info("Name\tPhone\tTIN\tAddress\tCRR\tCapital");
        for (Entity entity : entities) {
            log.info(entity.toString() + " " + statistic.getTotalDuringTimeByUser(entity));
        }

        log.info("\nList of individuals");
        log.info("Name\tPhone\tINIPA");
        for (Individual individual : individuals) {
            log.info(individual.toString() + " " + statistic.getTotalDuringTimeByUser(individual));
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
            log.info("Error in getSize(): " + e.getMessage());
        }

        return -1;
    }

    public void Backup() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter file name for Entity's: ");
        String toEntitys = scanner.next();
        System.out.println("Enter file name for Individuals: ");
        String toIndividuals = scanner.next();

        this.EntitysToFile(toEntitys);
        this.IndividualsToFile(toIndividuals);
    }
}