package org.example.service;

import org.example.model.User;
import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;

public class LoginServiceImpl implements LoginService {
    public List<User> users = new ArrayList<>();

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
