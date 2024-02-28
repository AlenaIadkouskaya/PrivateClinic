package org.example.service;

import org.example.model.User;
import org.example.model.Visit;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface FileService {
    void writeToFileUsers(List<User> users);
    void writeToFileVisits(Map<LocalDate, List<Visit>> listVisits);
    List<User> getUsersFromFile();
    Map<LocalDate, List<Visit>> getVisitsFromFile();
}
