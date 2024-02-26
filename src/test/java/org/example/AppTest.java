package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.exception.ExceptionLackOfVisit;
import org.example.model.Doctor;
import org.example.model.Specialization;
import org.example.model.User;
import org.example.model.Visit;
import org.example.service.LoginService;
import org.example.service.LoginServiceImpl;
import org.example.service.VisitServiceImpl;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    @Test
    public void creating_makingAppointment_test() {
        //given
        List<User> listOfUsers = Utils.getUsersFromFile();

        LoginService loginService = new LoginServiceImpl();
        VisitServiceImpl visitService = new VisitServiceImpl();

        loginService.setUsers(listOfUsers);

        String login = "doctor1";
        User currentUser = loginService.login(login);

        Visit newVisitAt9 = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                currentUser);
        Visit newVisitAt10 = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(10, 0),
                currentUser);
        visitService.addVisit(newVisitAt9);
        visitService.addVisit(newVisitAt10);

        currentUser = loginService.login("patient1");

        visitService.makeAppointment(1, currentUser);
        //when
        List<Visit> currentRecords = visitService.showVisit();
        //then
        assertThat(currentRecords.size()).isEqualTo(2);
        assertThat(currentRecords.get(1).getPatient()).isNull();
        assertThat(currentRecords.get(0).getPatient()).isEqualTo(currentUser);
        assertThat(currentRecords.get(0).getDoctor()).isEqualTo(currentRecords.get(1).getDoctor());
    }

    @Test
    public void deleting_appointment() {
        //given
        List<User> listOfUsers = Utils.getUsersFromFile();

        LoginService loginService = new LoginServiceImpl();
        VisitServiceImpl visitService = new VisitServiceImpl();

        Visit.countVisits = 1;

        loginService.setUsers(listOfUsers);

        String login = "doctor1";
        User currentUser = loginService.login(login);

        Visit newVisitAt9 = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(9, 0),
                currentUser);
        Visit newVisitAt10 = new Visit(LocalDate.of(2024, 3, 1), LocalTime.of(10, 0),
                currentUser);
        visitService.addVisit(newVisitAt9);
        visitService.addVisit(newVisitAt10);

        currentUser = loginService.login("patient1");

        visitService.makeAppointment(1, currentUser);
        List<Visit> currentRecords = new ArrayList<>();
        //when
        try {
            visitService.deleteVisit(2);
            visitService.deleteVisit(1);

        }
        catch (ExceptionLackOfVisit e){
            //then
            currentRecords = visitService.showVisit();
            assertThat(currentRecords.size()).isEqualTo(1);
            assertThat(currentRecords.get(0).getPatient()).isNotNull();
            assertThat(e.getMessage()).isNotEqualTo("");
        }

    }
}
