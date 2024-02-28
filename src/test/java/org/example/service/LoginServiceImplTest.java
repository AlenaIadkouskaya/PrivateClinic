package org.example.service;

import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.model.Specialization;
import org.example.model.User;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginServiceImplTest {

    @Test
    public void is_login_true() {
        //given
        LoginServiceImpl loginService = new LoginServiceImpl();
        List<User> users = new ArrayList<>();
        User patient = new Patient(1, "Mateusz", "Chory", "patient1", "111", "322-322-322");
        User doctor = new Doctor(2, "Agnieszka", "Pierwsza", "doctor1", "222", Specialization.INTERN);
        users.add(patient);
        users.add(doctor);
        loginService.setUsers(users);

        // when
        User login = loginService.login("doctor1", "222");

        // then
        assertThat(login).isNotNull();
        assertThat(login.getLogin()).isEqualTo("doctor1");
    }
}