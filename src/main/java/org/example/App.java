package org.example;

import org.example.controller.UserController;
import org.example.service.LoginService;
import org.example.service.LoginServiceImpl;

public class App {
    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.run();
    }
}
