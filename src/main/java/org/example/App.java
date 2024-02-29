package org.example;

import org.example.controller.UserController;
import org.example.service.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginService loginService = new LoginServiceImpl();
        VisitService visitService = new VisitServiceImpl();
        FileService fileService = new FileServiceImpl();
        UserController userController = new UserController(loginService, visitService, fileService, scanner);
        userController.run();
    }
}
