package org.example.service;

import junit.framework.TestCase;
import org.example.exception.ExceptionLackOfVisit;
import org.example.model.Doctor;
import org.example.model.Specialization;
import org.example.model.Visit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
        Visit firstVisit = new Visit(Visit.countVisits, LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "d1", "d2", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        Visit newVisit = new Visit(Visit.countVisits, LocalDate.of(2024, 3, 1), LocalTime.of(10, 0),
                new Doctor(1, "d1", "d2", Specialization.ALLERGIST));
        //when
        visitService.addVisit(newVisit);
        //then
        assertThat(visitService.listVisits.get(LocalDate.of(2024, 3, 1)).size()).isEqualTo(2);
    }

    @Test
    public void test_add_visit_in_other_day() {
        //given
        Visit firstVisit = new Visit(Visit.countVisits, LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "d1", "d2", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        Visit newVisit = new Visit(Visit.countVisits, LocalDate.of(2024, 3, 1), LocalTime.of(10, 0),
                new Doctor(1, "d1", "d2", Specialization.ALLERGIST));
        visitService.addVisit(newVisit);
        Visit nextVisit = new Visit(Visit.countVisits, LocalDate.of(2024, 4, 1), LocalTime.of(10, 0),
                new Doctor(1, "d1", "d2", Specialization.ALLERGIST));
        //when
        visitService.addVisit(nextVisit);
        //then
        assertThat(visitService.listVisits.get(LocalDate.of(2024, 4, 1)).size()).isEqualTo(1);
        assertThat(visitService.listVisits.get(LocalDate.of(2024, 3, 1)).size()).isEqualTo(2);
    }

    @Test
    public void test_add_with_empty_visit() {
        //given
        VisitServiceImpl visitService = new VisitServiceImpl();
        //when
        try {
            visitService.addVisit(null);
        } catch (NullPointerException e) {
            //then
            assertThat(e.getMessage()).isNotEqualTo("");
        }
    }

    @Test
    public void test_delete_exist_visit() {
        //given
        Visit firstVisit = new Visit(Visit.countVisits, LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "d1", "d2", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        Visit newVisit = new Visit(Visit.countVisits, LocalDate.of(2024, 3, 1), LocalTime.of(10, 0),
                new Doctor(1, "d1", "d2", Specialization.ALLERGIST));
        visitService.addVisit(newVisit);
        Visit nextVisit = new Visit(Visit.countVisits, LocalDate.of(2024, 4, 1), LocalTime.of(10, 0),
                new Doctor(1, "d1", "d2", Specialization.ALLERGIST));
        visitService.addVisit(nextVisit);
        //when
        visitService.deleteVisit(2);
        //then
        assertThat(visitService.listVisits.get(LocalDate.of(2024, 3, 1)).size()).isEqualTo(1);
    }

    @Test
    public void test_delete_exist_visit_that_not_exist() {
        //given
        Visit firstVisit = new Visit(Visit.countVisits, LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "d1", "d2", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        try {
            //when
            visitService.deleteVisit(2);
        } catch (ExceptionLackOfVisit e) {
            //then
            assertThat(e.getMessage()).isNotEqualTo("");
        }
    }

    @Test
    public void test_show_list_of_all_visits() {
        //given
        Visit firstVisit = new Visit(Visit.countVisits, LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "d1", "d2", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        Visit newVisit = new Visit(Visit.countVisits, LocalDate.of(2024, 3, 1), LocalTime.of(10, 0),
                new Doctor(1, "d1", "d2", Specialization.ALLERGIST));
        visitService.addVisit(newVisit);
        Visit nextVisit = new Visit(Visit.countVisits, LocalDate.of(2024, 4, 1), LocalTime.of(10, 0),
                new Doctor(1, "d1", "d2", Specialization.ALLERGIST));
        visitService.addVisit(nextVisit);
        //when
        List<Visit> receivedListVisits = visitService.showVisit();
        //then
        assertThat(receivedListVisits.size()).isEqualTo(3);
    }

    @Test
    public void test_cancel_visit_without_patient() {
        //given
        Visit firstVisit = new Visit(Visit.countVisits, LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "d1", "d2", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        //when
        try {
            visitService.canselVisit(1);
        } catch (ExceptionLackOfVisit e) {
            //then
            assertThat(e.getMessage()).isEqualTo("This visit is not exist or there is not patient record for this time!");
        }
    }
}