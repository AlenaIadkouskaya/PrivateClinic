package org.example.service;

import org.example.model.Visit;

import java.util.List;

interface VisitService {

    void addVisit(Visit visit);

    void deleteVisit(Integer id);

    void canselVisit(Integer id);

    List<Visit> showVisit();
}
