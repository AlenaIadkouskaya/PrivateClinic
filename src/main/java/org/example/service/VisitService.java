package org.example.service;

import org.example.model.User;
import org.example.model.Visit;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface VisitService {
    void addVisit(Visit visit);
    boolean checkAllVisits(Visit visit);

    void deleteVisit(Integer id);

    void canselVisit(Integer id);

    List<Visit> showVisit();

    void makeAppointment(Integer id, User patient);

    void setListVisits(Map<LocalDate, List<Visit>> listVisits);

    Map<LocalDate, List<Visit>> getListVisits();
}
