package org.example.service;

import java.util.Scanner;

public class MenuService {
    public static void printMainMenu() {
        System.out.println();
        System.out.println("PRIVATE CLINIC");
        System.out.print("Enter your login: ");
        System.out.print("Enter your Password: ");
    }

    public static void printDoctorMenu() {
        System.out.println();
        System.out.println("---------DOCTOR MENU----------");
        System.out.println("Choose your options:");
        System.out.println("Enter    1    for Show Visit");
        System.out.println("Enter    2    for Add Visit");
        System.out.println("Enter    3    for Delete Visit");
        System.out.println("Enter    4    for Cancel Visit");
        System.out.println("Enter    5    for Search Visit");
        System.out.println("Enter    6    for Change User");
        System.out.println("Enter    7    for Exit");
        System.out.println("-------------------------------------");
        System.out.println();
        System.out.print("Input options: ");
    }

    public static void printPatientMenu() {
        System.out.println();
        System.out.println("--------------PATIENT MENU--------------");
        System.out.println("Choose your options:");
        System.out.println("Enter    1    for Show Visit");
        System.out.println("Enter    2    for Make appointment Visit");
        System.out.println("Enter    3    for Search Visit");
        System.out.println("Enter    4    for Change User");
        System.out.println("Enter    5    for Exit");
        System.out.println("-----------------------------------------");
        System.out.println();
        System.out.print("Input options: ");
    }

//    public static Integer[] inputDate() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input year: ");
//        int year = scanner.nextInt();
//        System.out.print("Input month: ");
//        int month = scanner.nextInt();
//        System.out.print("Input day: ");
//        int day = scanner.nextInt();
//        scanner.close();
//        return new Integer[]{year, month, day};
//    }
}
