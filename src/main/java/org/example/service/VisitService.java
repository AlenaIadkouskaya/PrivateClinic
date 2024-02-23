package org.example.service;

import org.example.model.Patient;
import org.example.model.Visit;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface VisitService {

    void addVisit(Visit visit);

    void deleteVisit(Integer id);

    void canselVisit(Integer id);

    List<Visit> showVisit();

    void makeAppointment(Integer id, Patient patient);

}
