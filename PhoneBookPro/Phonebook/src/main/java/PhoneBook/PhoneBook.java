package PhoneBook;

import java.io.*;
import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<Entity> entities = new ArrayList<>();
    private ArrayList<Individual> individuals = new ArrayList<>();
    ArrayList<Call> calls = new ArrayList<>();
    ArrayList<Conference> conferences = new ArrayList<>();
    Statistic statistic = new Statistic();

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

    public void ShowAll() {
        ShowEntitys();
        ShowIndividuals();
    }

    public void ShowEntitys() {
        System.out.println("List of entity's");
        System.out.println("Name\t\t\t\t\t\tPhone\t\t\t\tTIN\t\tAddress\t\t\tCRR\t\tCapital");
        for (Entity entity : entities) {
            System.out.println(entity.toString());
        }
    }

    public void ShowIndividuals() {
        System.out.println("List of individuals");
        System.out.println("Name\t\t\t\t\t\tPhone\t\t\t\tINIPA");
        for (Individual individual : individuals) {
            System.out.println(individual.toString());
        }
    }

    public void toFile(String fileName) {
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
            writer.write("Type;Name;Phone;INIPA\n");
            for (Individual individual : individuals) {
                writer.write(Type.Individual + ";" + individual.toCSV() + "\n");
            }
            writer.write("Type;Name;Phone;TIN;Address;CRR;Capital\n");
            for (Entity entity : entities) {
                writer.write(Type.Entity + ";" + entity.toCSV() + "\n");
            }
        } catch (IOException exc) {
            System.out.println("Error creating file: " + exc.getMessage());
        }
    }

    public void fromFile(String fileName) { //TOneverDO
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File not found");
        }

        try (FileReader reader = new FileReader(fileName)) {
            char[] buffer = new char[(int)file.length()];
            reader.read(buffer);
//            System.out.println(buffer);
            String raw = new String(buffer);
            String[] rows = raw.split("\n");

            if (rows.length < 2) {
                return;
            }

            for (String row : rows) {
//                System.out.println(row);
                String[] elems = row.split(";");

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
}

