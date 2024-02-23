package org.example;

import org.example.controller.UserController;
import org.example.model.Doctor;

public class App {
    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.run();
    }
}
