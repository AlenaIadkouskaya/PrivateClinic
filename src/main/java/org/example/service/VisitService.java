package org.example.service;

import org.example.model.Visit;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

interface VisitService {

    void addVisit(Visit visit);

    void deleteVisit(Integer id);

    void canselVisit(Integer id);

    List<Visit> showVisit();
    //Map<LocalDate, List<Visit>> showVisit();
}
