package org.example.service;

import org.example.model.Visit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisitServiceImpl implements VisitService {
    Map<LocalDate, List<Visit>> listVisits;

    public VisitServiceImpl() {
        this.listVisits = new HashMap<LocalDate, List<Visit>>();
    }

    @Override
    public void addVisit(Visit visit) {
        LocalDate dateOfVisit = visit.getDate();
        List<Visit> currentListOfVisits = listVisits.get(dateOfVisit);
        if (currentListOfVisits == null) {
            currentListOfVisits = new ArrayList<Visit>();
        }
        currentListOfVisits.add(visit);
        listVisits.put(dateOfVisit, currentListOfVisits);
    }

    @Override
    public void deleteVisit(Integer id) {

    }

    @Override
    public void canselVisit(Integer id) {

    }

    @Override
    public List<Visit> showVisit() {
        return null;
    }

}
