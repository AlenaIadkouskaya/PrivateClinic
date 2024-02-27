package org.example;

import org.example.controller.UserController;
import org.example.service.LoginService;
import org.example.service.LoginServiceImpl;
import org.example.service.VisitServiceImpl;

import java.io.Console;

public class App {
    public static void main(String[] args) {

        LoginService loginService = new LoginServiceImpl();
        VisitServiceImpl visitService = new VisitServiceImpl();
        UserController userController = new UserController(loginService, visitService);
        userController.run();
    }
}
