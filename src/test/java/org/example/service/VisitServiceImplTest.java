package org.example.service;

import junit.framework.TestCase;
import org.example.model.Doctor;
import org.example.model.Specialization;
import org.example.model.Visit;
//import org.junit.jupiter.api.Test;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VisitServiceImplTest extends TestCase {
    @Test
    public void test_add_visit_when_not_exists_visits_on_this_day() {
        //given
        Visit newVisit = new Visit(Visit.countVisits++, LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "d1", "d2", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        //when
        visitService.addVisit(newVisit);
        //then
        assertThat(visitService.listVisits.get(LocalDate.of(2024, 3, 1)).size()).isEqualTo(1);
    }

    @Test
    public void test_add_visit_when_exists_visits_in_this_day() {
        //given
        Visit firstVisit = new Visit(Visit.countVisits++, LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "d1", "d2", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        Visit newVisit = new Visit(Visit.countVisits++, LocalDate.of(2024, 3, 1), LocalTime.of(10, 0),
                new Doctor(1, "d1", "d2", Specialization.ALLERGIST));
        //when
        visitService.addVisit(newVisit);
        //then
        assertThat(visitService.listVisits.get(LocalDate.of(2024, 3, 1)).size()).isEqualTo(2);
    }
}