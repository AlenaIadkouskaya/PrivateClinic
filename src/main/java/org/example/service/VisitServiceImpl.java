package org.example.service;

import org.example.exception.ExceptionLackOfVisit;
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
        if (visit == null) {
            throw new NullPointerException("Visit can't be empty!");
        }
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
        boolean operationExecuted = false;
        for (Map.Entry<LocalDate, List<Visit>> entry : listVisits.entrySet()) {
            List<Visit> nextList = entry.getValue();
            for (int i = 0; i < nextList.size(); i++) {
                if (nextList.get(i).getId().equals(id)) {
                    nextList.remove(i);
                    operationExecuted = true;
                    break;
                }
            }
            if (operationExecuted) {
                break;
            }
        }
        if (!operationExecuted) {
            throw new ExceptionLackOfVisit("This visit is not exist!");
        }
    }

    @Override
    public void canselVisit(Integer id) {

    }

    @Override
    public List<Visit> showVisit() {

        return null;
    }

}
