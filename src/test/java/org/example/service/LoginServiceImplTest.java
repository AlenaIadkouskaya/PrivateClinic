package org.example.service;

import static org.assertj.core.api.Assertions.*;

import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.model.Specialization;
import org.example.model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LoginServiceImplTest {

    @Test
    public void is_login_true() {
        //given
        LoginServiceImpl loginService = new LoginServiceImpl();
        List<User> users = new ArrayList<>();
        User patient = new Patient(1, "Patient", "Patient", "patient1", "322-322-322");
        User doctor = new Doctor(2, "Doctor", "Doctor", "doctor1", Specialization.CARDIOLOGIST);
        users.add(patient);
        users.add(doctor);
        loginService.fakeUsers();
//        loginService.users();

        // when
        User zalogowanyUżytkownik = loginService.login("doctor1");

        // then
        assertThat(zalogowanyUżytkownik).isNotNull();
        assertThat(zalogowanyUżytkownik.getLogin()).isEqualTo("doctor1");
    }
}