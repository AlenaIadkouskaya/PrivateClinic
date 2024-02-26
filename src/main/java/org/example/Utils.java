package org.example;

import org.example.model.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static void writeToFileUsers(List<User> users) {
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

    public static void writeToFileVisits(Map<LocalDate, List<Visit>> listVisits) {
        try {
            PrintWriter printWriter = new PrintWriter("visits.txt", StandardCharsets.UTF_8);
            for (Map.Entry<LocalDate, List<Visit>> entry : listVisits.entrySet()) {
                for (Visit visit : entry.getValue()) {
                    printWriter.println(entry.getKey() + ";" + visit.getId() + ";" + visit.getTime() + ";" + visit.getDoctor().getId());
                }
            }
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Error. Something went wrong");
        }
    }

    public static List<User> getUsersFromFile() {
        Path filePathUsers = Path.of("users.txt");
        List<User> users = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(filePathUsers);
            for (String line : lines) {
                String[] strings = line.split(";");
                int id = Integer.parseInt(strings[0].trim());
                String name = strings[1].trim();
                String surname = strings[2].trim();
                String login = strings[3].trim();
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

    public static Map<LocalDate, List<Visit>> getVisitsFromFile() {
        Path filePathVisits = Path.of("visits.txt");
        Map<LocalDate, List<Visit>> mapVisit = new HashMap<>();
        List<Visit> visits = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(filePathVisits);
            for (String line : lines) {
                String[] strings = line.split(";");
                LocalDate date = LocalDate.parse(strings[0].trim());
                int id = Integer.parseInt(strings[1].trim());
                LocalTime time = LocalTime.parse(strings[2].trim());
                String idDoctor = strings[3].trim();
                Visit visit = new Visit(date, time, getDoctorFromId(idDoctor));
                visits.add(visit);
                mapVisit.put(date, visits);
            }
        } catch (IOException e) {
            System.out.println("Error. Cannot read file");
        }
        return mapVisit;
    }

    private static User getDoctorFromId(String idDoctor) {
        for (User user : getUsersFromFile()) {
            if (user.getId().equals(Integer.parseInt(idDoctor))) {
                return user;
            }
        }
        return null;
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
