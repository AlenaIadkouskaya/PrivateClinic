package org.example.service;

import org.example.Utils;
import org.example.exception.ExceptionLackOfVisit;
import org.example.model.Patient;
import org.example.model.User;
import org.example.model.Visit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisitServiceImpl implements VisitService {
    private Map<LocalDate, List<Visit>> listVisits;

    public VisitServiceImpl() {
        this.listVisits = new HashMap<LocalDate, List<Visit>>();
    }

    @Override
    public void addVisit(Visit visit) {
        if (visit == null) {
            throw new NullPointerException("Visit can't be empty!");
        }
        boolean thisVisitExist = checkAllVisits(visit);
        if (thisVisitExist) {
            throw new ExceptionLackOfVisit("You can't add visit with specified parameters!");
        }
        LocalDate dateOfVisit = visit.getDate();
        List<Visit> currentListOfVisits = listVisits.get(dateOfVisit);
        if (currentListOfVisits == null) {
            currentListOfVisits = new ArrayList<Visit>();
        }
        currentListOfVisits.add(visit);
        listVisits.put(dateOfVisit, currentListOfVisits);
    }

    private boolean checkAllVisits(Visit visit) {
        for (Map.Entry<LocalDate, List<Visit>> entry : listVisits.entrySet()) {
            List<Visit> nextList = entry.getValue();
            for (int i = 0; i < nextList.size(); i++) {
                Visit nextVisit = nextList.get(i);
                if (nextVisit.equals(visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void deleteVisit(Integer id) {
        boolean operationExecuted = false;
        for (Map.Entry<LocalDate, List<Visit>> entry : listVisits.entrySet()) {
            List<Visit> nextList = entry.getValue();
            for (int i = 0; i < nextList.size(); i++) {
                Visit nextVisit = nextList.get(i);
                if (nextVisit.getId().equals(id) && nextVisit.getPatient() == null) {
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
            throw new ExceptionLackOfVisit("This visit is not exist or the visit needs to be cancelled!");
        }
    }

    @Override
    public void canselVisit(Integer id) {
        boolean operationExecuted = false;
        for (Map.Entry<LocalDate, List<Visit>> entry : listVisits.entrySet()) {
            List<Visit> nextList = entry.getValue();
            for (int i = 0; i < nextList.size(); i++) {
                Visit nextVisit = nextList.get(i);
                if (nextVisit.getId().equals(id) && nextVisit.getPatient() != null) {
                    nextVisit.setPatient(null);
                    operationExecuted = true;
                    break;
                }
            }
            if (operationExecuted) {
                break;
            }
        }
        if (!operationExecuted) {
            throw new ExceptionLackOfVisit("This visit is not exist or there is not patient record for this time!");
        }
    }

    @Override
    public List<Visit> showVisit() {
        List<Visit> listAllVisits = new ArrayList<>();
        for (Map.Entry<LocalDate, List<Visit>> entry : listVisits.entrySet()) {
            listAllVisits.addAll(entry.getValue());
        }
        Utils.showToConsole(listAllVisits);
        return listAllVisits;
    }

    @Override
    public void makeAppointment(Integer id, User patient) {
        boolean operationExecuted = false;
        for (Map.Entry<LocalDate, List<Visit>> entry : listVisits.entrySet()) {
            List<Visit> nextList = entry.getValue();
            for (int i = 0; i < nextList.size(); i++) {
                Visit nextVisit = nextList.get(i);
                if (nextVisit.getId().equals(id) && nextVisit.getPatient() == null) {
                    nextVisit.setPatient(patient);
                    operationExecuted = true;
                    break;
                }
            }
            if (operationExecuted) {
                break;
            }
        }
        if (!operationExecuted) {
            throw new ExceptionLackOfVisit("This visit is not exist or there is other patient record for this time!");
        }
    }

    public Map<LocalDate, List<Visit>> getListVisits() {
        return listVisits;
    }
}
