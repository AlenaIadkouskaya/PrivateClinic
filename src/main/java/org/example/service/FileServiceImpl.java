package org.example.service;

import org.example.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.module.FindException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileServiceImpl implements FileService {
    @Override
    public void writeToFileUsers(List<User> users) {
        try {
            PrintWriter printWriter = new PrintWriter("users.txt", StandardCharsets.UTF_8);
            for (User user : users) {
                if (user instanceof Doctor) {
                    printWriter.println(user.getId() + ";" + user.getName() + ";" + user.getSurname() + ";" + user.getLogin() + ";" + user.getPassword() + ";" +
                            ((Doctor) user).getSpecialization() + ";" + "-");
                }
                if (user instanceof Patient) {
                    printWriter.println(user.getId() + ";" + user.getName() + ";" + user.getSurname() + ";" + user.getLogin() + ";" + user.getPassword() + ";" +
                            "-" + ";" + ((Patient) user).getNumberTelephone());
                }
            }
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Error. Something went wrong");
        }
    }

    @Override
    public void writeToFileVisits(Map<LocalDate, List<Visit>> listVisits) {
        try {
            PrintWriter printWriter = new PrintWriter("visits.txt", StandardCharsets.UTF_8);
            for (Map.Entry<LocalDate, List<Visit>> entry : listVisits.entrySet()) {
                for (Visit visit : entry.getValue()) {
                    if (visit.getPatient() != null) {
                        printWriter.println(entry.getKey() + ";" + visit.getId() + ";" + visit.getTime() + ";" + visit.getDoctor().getId() + ";" + visit.getPatient().getId());
                    }
                    printWriter.println(entry.getKey() + ";" + visit.getId() + ";" + visit.getTime() + ";" + visit.getDoctor().getId() + ";" + "-");
                }
            }
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Error. Something went wrong");
        }
    }

    @Override
    public List<User> getUsersFromFile() {
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
                String password = strings[4].trim();
                String numberTelephone = strings[6].trim();
                if (numberTelephone.equals("-")) {
                    Specialization specialization = checkSpecialization(strings[5].trim());
                    User doctor = new Doctor(id, name, surname, login, password, specialization);
                    users.add(doctor);
                } else {
                    User patient = new Patient(id, name, surname, login, password, numberTelephone);
                    users.add(patient);
                }
            }
        } catch (IOException e) {
            System.out.println("Error. Cannot read file");
        }
        return users;
    }

    @Override
    public Map<LocalDate, List<Visit>> getVisitsFromFile() {
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
                String idPatient = strings[4].trim();
                Visit visit = new Visit(date, time, getDoctorFromId(idDoctor), idPatient.equals("-") ? null : getPatientFromId(idPatient));
                visits.add(visit);
                //mapVisit.put(date, visits);
                VisitServiceImpl.pasteToListVisits(visit, mapVisit);
            }
            Visit.countVisits = visits.size() + 1;
        } catch (IOException e) {
            System.out.println("Error. Cannot read file");
        }
        return mapVisit;
    }

    public User getDoctorFromId(String idDoctor) {
        for (User user : getUsersFromFile()) {
            if (user.getId().equals(Integer.parseInt(idDoctor)) && (user instanceof Doctor)) {
                return user;
            }
        }
        throw new FindException("Object not found");
    }

    private User getPatientFromId(String idPatient) {
        for (User user : getUsersFromFile()) {
            if (!idPatient.equals("-") && user.getId().equals(Integer.parseInt(idPatient)) && (user instanceof Patient)) {
                return user;
            }
        }
        throw new FindException("Object not found");
    }

    private static Specialization checkSpecialization(String str) {
        for (Specialization nextItem : Specialization.values()) {
            if (str.equals(nextItem.name())) {
                return nextItem;
            }
        }
        throw new FindException("Specialization not found");
    }
}
