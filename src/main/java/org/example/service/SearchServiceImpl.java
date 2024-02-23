package org.example.service;

import org.example.model.Visit;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class SearchServiceImpl implements SearchService{
    @Override
    public List<Visit> searchVisit(LocalDate date, Map<LocalDate, List<Visit>> listVisits) {

        return listVisits.get(date);

    }
}
