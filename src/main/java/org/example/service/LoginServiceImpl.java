package org.example.service;

import org.example.exception.ExceptionLackOfVisit;
import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.model.Specialization;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class LoginServiceImpl implements LoginService {
    public List<User> users = new ArrayList<>();

    @Override
    public void fakeUsers() {
        users.add(new Patient(1, "Patient", "Patient", "patient1", "111", "322-322-322"));
        users.add(new Doctor(2, "Doctor", "Doctor", "doctor1", "222", Specialization.CARDIOLOGIST));
    }

    @Override
    public User login(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equalsIgnoreCase(login) && user.getPassword().equalsIgnoreCase(password)) {
                return user;
            }
        }
        throw new ExceptionLackOfVisit("Not found User");
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
