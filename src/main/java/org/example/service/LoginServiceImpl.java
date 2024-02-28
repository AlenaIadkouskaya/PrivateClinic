package org.example.service;

import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.model.Specialization;
import org.example.model.User;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;

public class LoginServiceImpl implements LoginService {
    public List<User> users = new ArrayList<>();

//    @Override
//    public void fakeUsers() {
//        users.add(new Patient(1, "Mateusz", "Chory", "patient1", "111", "322-322-322"));
//        users.add(new Doctor(2, "Agnieszka", "Pierwsza", "doctor1", "222", Specialization.INTERN));
//        users.add(new Doctor(3, "Adam", "Adamowicz", "doctor2", "222", Specialization.CARDIOLOGIST));
//        users.add(new Doctor(4, "Piotr", "Slipy", "doctor3", "222", Specialization.OCULIST));
//        users.add(new Doctor(5, "Dorota", "Pryszcz", "doctor4", "222", Specialization.DERMATOLOGIST));
//        users.add(new Doctor(6, "Marta", "Kwiatek", "doctor5", "222", Specialization.ALLERGIST));
//    }

    @Override
    public User login(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equalsIgnoreCase(login) && user.getPassword().equalsIgnoreCase(password)) {
                return user;
            }
        }
        throw new FindException("Not found User");
    }

//    public void addUser(Patient patient){
//        users.add(patient);
//    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
