package org.example.service;

import junit.framework.TestCase;
import org.example.Utils;
import org.example.exception.ExceptionLackOfVisit;
import org.example.model.Doctor;
import org.example.model.Patient;
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
        Visit newVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "d1", "d2", "l1", "111", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        //when
        visitService.addVisit(newVisit);
        //then
        assertThat(visitService.getListVisits().get(LocalDate.of(2024, 3, 1)).size()).isEqualTo(1);
    }

    @Test
    public void test_add_visit_twice() {
        //given
        Visit newVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "d1", "d2", "l1", "111", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(newVisit);
        try {
            //when
            visitService.addVisit(newVisit);
        } catch (ExceptionLackOfVisit e) {
            //then
            assertThat(e.getMessage()).isNotEqualTo("");
        }
    }

    @Test
    public void test_add_visit_twice_with_same_parametrs() {
        //given
        Visit firstVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "d1", "d2", "l1", "111", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        Visit secondVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "d1", "d2", "l1", "111", Specialization.ALLERGIST));
        try {
            //when
            visitService.addVisit(secondVisit);
        } catch (ExceptionLackOfVisit e) {
            //then
            assertThat(e.getMessage()).isNotEqualTo("");
        }
    }

    @Test
    public void test_add_visit_when_exists_visits_in_this_day() {
        //given
        Visit firstVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "n1", "s1", "l1", "111", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        Visit newVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(10, 0),
                new Doctor(1, "n2", "s2", "l2", "222", Specialization.ALLERGIST));
        //when
        visitService.addVisit(newVisit);
        //then
        assertThat(visitService.getListVisits().get(LocalDate.of(2024, 3, 1)).size()).isEqualTo(2);
    }

    @Test
    public void test_add_visit_in_other_day() {
        //given
        Visit firstVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "n1", "s2", "l2", "222", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        Visit newVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(10, 0),
                new Doctor(1, "n2", "s2", "l2", "222", Specialization.ALLERGIST));
        visitService.addVisit(newVisit);
        Visit nextVisit = new Visit(LocalDate.of(2024, 4, 1), LocalTime.of(10, 0),
                new Doctor(1, "n3", "s3", "l3", "333", Specialization.ALLERGIST));
        //when
        visitService.addVisit(nextVisit);
        //then
        assertThat(visitService.getListVisits().get(LocalDate.of(2024, 4, 1)).size()).isEqualTo(1);
        assertThat(visitService.getListVisits().get(LocalDate.of(2024, 3, 1)).size()).isEqualTo(2);
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
        Visit firstVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "n1", "s1", "l1", "111", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        Visit newVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(10, 0),
                new Doctor(1, "n2", "s2", "l2", "222", Specialization.ALLERGIST));
        visitService.addVisit(newVisit);
        Visit nextVisit = new Visit(LocalDate.of(2024, 4, 1), LocalTime.of(10, 0),
                new Doctor(1, "n3", "s3", "l3", "333", Specialization.ALLERGIST));
        visitService.addVisit(nextVisit);
        //when
        visitService.deleteVisit(2);
        //then
        assertThat(visitService.getListVisits().get(LocalDate.of(2024, 3, 1)).size()).isEqualTo(1);
    }

    @Test
    public void test_delete_exist_visit_that_not_exist() {
        //given
        Visit firstVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "n1", "s1", "l1", "111", Specialization.ALLERGIST));
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
        Visit firstVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "n1", "s1", "l1", "111", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        Visit newVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(10, 0),
                new Doctor(1, "n2", "s2", "l2", "222", Specialization.ALLERGIST));
        visitService.addVisit(newVisit);
        Visit nextVisit = new Visit(LocalDate.of(2024, 4, 1), LocalTime.of(10, 0),
                new Doctor(1, "n3", "s3", "l3", "333", Specialization.ALLERGIST));
        visitService.addVisit(nextVisit);
        //when
        List<Visit> receivedListVisits = visitService.showVisit();
        //then
        assertThat(receivedListVisits.size()).isEqualTo(3);
    }

    @Test
    public void test_cancel_visit_without_patient() {
        //given
        Visit firstVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "n1", "s1", "l1", "111", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        visitService.showVisit();
        //when
        try {
            visitService.canselVisit(1);
            visitService.showVisit();
        } catch (ExceptionLackOfVisit e) {
            //then
            assertThat(e.getMessage()).isEqualTo("This visit is not exist or there is not patient record for this time!");
        }
    }

    @Test
    public void test_make_appointment_when_time_is_empty() {
        //given
        Visit firstVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "n1", "s1", "l1", "111", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        Patient newPatient = new Patient(1, "Mark", "Green", "log1", "111", "555777999");
        //when
        visitService.makeAppointment(Visit.countVisits - 1, newPatient);
        //then
        assertThat(visitService.getListVisits().get(LocalDate.of(2024, 3, 1)).get(0).getPatient()).isEqualTo(newPatient);
        visitService.showVisit();
    }

    @Test
    public void test_make_appointment_when_time_is_not_empty() {
        //given
        Visit firstVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "n1", "s1", "l1", "111", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        Patient firstPatient = new Patient(1, "Mark", "Green", "log1", "111", "555777999");
        Patient secondPatient = new Patient(2, "John", "Red", "log2", "222", "666111444");
        visitService.makeAppointment(Visit.countVisits - 1, firstPatient);
        visitService.showVisit();
        try {
            //when
            visitService.makeAppointment(Visit.countVisits - 1, secondPatient);
        } catch (ExceptionLackOfVisit e) {
            //then
            assertThat(e.getMessage()).isNotEqualTo("");
        }
    }

    @Test
    public void test_cancel_visit_with_patient() {
        //given
        Visit firstVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "n1", "s1", "l1", "111", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        Patient firstPatient = new Patient(1, "Mark", "Green", "log1", "111", "555777999");
        visitService.makeAppointment(Visit.countVisits - 1, firstPatient);
        //when
        try {
            visitService.canselVisit(Visit.countVisits - 1);
        } catch (ExceptionLackOfVisit e) {
            //then
            assertThat(e.getMessage()).isNotEqualTo("");
        }
    }

    @Test
    public void test_search_with_help_date() {
        //given
        SearchService searchService = new SearchServiceImpl();
        Visit firstVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                new Doctor(1, "n1", "s1", "l1", "111", Specialization.ALLERGIST));
        VisitServiceImpl visitService = new VisitServiceImpl();
        visitService.addVisit(firstVisit);
        Visit newVisit = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(10, 0),
                new Doctor(1, "n2", "s2", "l2", "222", Specialization.ALLERGIST));
        visitService.addVisit(newVisit);
        Visit nextVisit = new Visit(LocalDate.of(2024, 4, 1), LocalTime.of(10, 0),
                new Doctor(1, "n3", "s3", "l3", "333", Specialization.ALLERGIST));
        visitService.addVisit(nextVisit);
        //when
        List<Visit> listSearchVisits = searchService.searchVisit(LocalDate.of(2024, 3, 1), visitService.getListVisits());
        Utils.showToConsole(listSearchVisits);
        //then
        assertThat(listSearchVisits.size()).isEqualTo(2);
    }
}