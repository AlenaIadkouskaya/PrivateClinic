package org.example.service;

import org.example.model.Visit;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface SearchService {
    List<Visit> searchVisit(LocalDate date, Map<LocalDate, List<Visit>> listVisits);
}
