package org.example.service;

import org.example.model.User;

import java.util.List;

public interface LoginService {
//    void fakeUsers();
    User login (String login,String password);
    List<User> getUsers();
    void setUsers(List<User> users);
}
