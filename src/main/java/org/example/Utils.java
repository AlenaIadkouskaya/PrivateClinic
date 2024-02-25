package org.example;

import org.example.model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    private Utils() {
    }

    public static void showToConsole(List<Visit> listToShow) {
        System.out.println();
        System.out.println("LIST OF VISITS\n");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("|  ID  |    Data    |  Time  |            Doctor            |           Patient           |");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (Visit nextVisit : listToShow) {
            System.out.println("|" + Utils.addSpace(nextVisit.getId().toString(), 6) +
                    "|" + Utils.addSpace(nextVisit.getDate().toString(), 12) +
                    "|" + Utils.addSpace(nextVisit.getTime().toString(), 8) +
                    "|" + Utils.addSpace(nextVisit.getDoctor().toString(), 30) +
                    "|" + Utils.addSpace(nextVisit.getPatient() == null ? "-" : nextVisit.getPatient().toString(), 29) + "|");
        }
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    static String addSpace(String word, int lenghtString) {
        String retundWork = word;
        for (int i = 0; i < lenghtString - word.length(); i++) {
            retundWork = retundWork + " ";
        }
        return retundWork;
    }

    public static void writeToFile(List<User> users) {
        try {
            PrintWriter printWriter = new PrintWriter("users.txt", StandardCharsets.UTF_8);
            for (User user : users) {
                if (user instanceof Doctor) {
                    printWriter.println(user.getId() + ";" + user.getName() + ";" + user.getSurname() + ";" + user.getLogin() + ";" + ((Doctor) user).getSpecialization() + ";" + "-");
                }
                if (user instanceof Patient) {
                    printWriter.println(user.getId() + ";" + user.getName() + ";" + user.getSurname() + ";" + user.getLogin() + ";" + "-" + ";" + ((Patient) user).getNumberTelephone());
                }
            }
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Error. Something went wrong");
        }
    }

//    public static void readFromFile() {
//        try {
//            Scanner scanner = new Scanner(new File("users.txt"));
//            while (scanner.hasNext()) {
//                System.out.println(scanner.next());
//                getUsersFromFile();
//            }
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        }
//    }

    public static List<User> getUsersFromFile() {
        Path filePath = Path.of("users.txt");
        List<User> users = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                String[] strings = line.split(";");
                int id = Integer.parseInt(strings[0].trim());
                String name = strings[1].trim();
                String surname = strings[2].trim();
                String login = strings[3].trim();
//                Specialization specialization = Specialization.valueOf(strings[4].trim());
                Specialization specialization = checkSpecialization(strings[4].trim());
                String numberTelephone = strings[5].trim();
                if (numberTelephone.equals("-")) {
                    User doctor = new Doctor(id, name, surname, login, specialization);
                    users.add(doctor);
                } else {
                    User patient = new Patient(id, name, surname, login, numberTelephone);
                    users.add(patient);
                }
            }

        } catch (IOException e) {
            System.out.println("Error. Cannot read file");
        }
        return users;
    }

    private static Specialization checkSpecialization(String str) {
        for (Specialization nextItem : Specialization.values()) {
            if (str.equals(nextItem.name())) {
                return nextItem;
            }
        }
        return null;
    }
}
