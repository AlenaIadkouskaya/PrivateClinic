package org.example;

import org.example.controller.UserController;

public class App {
    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.run();
    }
}
