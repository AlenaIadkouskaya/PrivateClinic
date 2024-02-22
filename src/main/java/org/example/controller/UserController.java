package org.example.controller;

import org.example.service.MenuService;

import java.util.Scanner;

public class UserController {

    public void run() {
        MenuService menuService = new MenuService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            MenuService.printMainMenu();
            String userOption = scanner.nextLine();

            if (userOption.equalsIgnoreCase("EXIT")) {
                System.out.println("Goodbye!");
                break;
            }
            MenuService.mainMenuOptions(userOption);
        }
    }
}
