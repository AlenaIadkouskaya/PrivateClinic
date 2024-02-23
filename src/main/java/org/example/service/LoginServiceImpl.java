package org.example.service;

import org.example.exception.ExceptionLackOfVisit;
import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.model.Specialization;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class LoginServiceImpl implements LoginService{

    List<User> users = new ArrayList<>();
//    User user = new Doctor(01, "d", "d", Specialization.CARDIOLOGIST);


    @Override
    public User login(String login) {
        for (User user : users) {
            if (user instanceof Doctor){
                return user;
            }
        }
        throw new ExceptionLackOfVisit("Not found User");
    }

}
