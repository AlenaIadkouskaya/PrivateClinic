package org.example;

import org.example.controller.UserController;
import org.example.model.Doctor;
import org.example.model.Specialization;
import org.example.model.User;
import org.example.service.*;

import java.io.Console;
import java.io.SerializablePermission;

public class App {
    public static void main(String[] args) {
        LoginService loginService = new LoginServiceImpl();
        VisitService visitService = new VisitServiceImpl();
        FileService fileService = new FileServiceImpl();
        UserController userController = new UserController(loginService, visitService, fileService);
        userController.run();
    }
}
