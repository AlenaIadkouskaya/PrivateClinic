package org.example;

import org.example.controller.UserController;
import org.example.service.*;

public class App {
    public static void main(String[] args) {
        LoginService loginService = new LoginServiceImpl();
        VisitService visitService = new VisitServiceImpl();
        FileService fileService = new FileServiceImpl();
        UserController userController = new UserController(loginService, visitService, fileService);
        userController.run();
    }
}
