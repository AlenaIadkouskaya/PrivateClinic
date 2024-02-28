package org.example.service;

import org.example.model.User;

public class MenuService {
    public static void printMainMenu() {
        System.out.println();
        System.out.println("PRIVATE CLINIC");
        System.out.print("Enter your Login: ");
    }

    public static void printDoctorMenu(User user) {
        System.out.println();
        System.out.println("-----------DOCTOR MENU---------");
        System.out.println(user.getName() + " " + user.getSurname());
        System.out.println("Choose your options:        ");
        System.out.println("Enter    1    for Show Visit");
        System.out.println("Enter    2    for Add Visit");
        System.out.println("Enter    3    for Delete Visit");
        System.out.println("Enter    4    for Cancel Visit");
        System.out.println("Enter    5    for Search Visit");
        System.out.println("Enter    6    for Change User");
        System.out.println("Enter    7    for Exit");
        System.out.println("------------------------------");
        System.out.println();
        System.out.print("Input options: ");
    }

    public static void printPatientMenu(User user) {
        System.out.println();
        System.out.println("--------------PATIENT MENU--------------");
        System.out.println(user.getName() + " " + user.getSurname());
        System.out.println("Choose your options:");
        System.out.println("Enter    1    for Show Visit");
        System.out.println("Enter    2    for Make appointment Visit");
        System.out.println("Enter    3    for Search Visit");
        System.out.println("Enter    4    for Change User");
        System.out.println("Enter    5    for Exit");
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.print("Input options: ");
    }
}
