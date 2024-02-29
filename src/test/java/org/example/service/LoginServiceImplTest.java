package org.example.service;

import org.example.controller.UserController;
import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.model.Specialization;
import org.example.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginServiceImplTest {

    @Test
    public void is_login_true() {
        //given
        List<User> users = new ArrayList<>();
        User patient = new Patient(1, "Mateusz", "Chory", "patient1", "111", "322-322-322");
        User doctor = new Doctor(2, "Agnieszka", "Pierwsza", "doctor1", "222", Specialization.INTERN);
        users.add(patient);
        users.add(doctor);
        LoginService loginService = Mockito.mock(LoginServiceImpl.class);
        Scanner mockedScanner = Mockito.mock(Scanner.class);
        FileService mockedFileService = Mockito.mock(FileServiceImpl.class);
        VisitService visitService = new VisitServiceImpl();
        Mockito.when(mockedFileService.getUsersFromFile()).thenReturn(users);
        Mockito.when(mockedScanner.nextLine()).thenReturn("patient1");



        // when
        UserController userController = new UserController(loginService, visitService, mockedFileService, mockedScanner);

//        User login = loginService.login("doctor1", "222");

        // then
        userController.run();
//        assertThat(login).isNotNull();
//        assertThat(login.getLogin()).isEqualTo("doctor1");
    }
}