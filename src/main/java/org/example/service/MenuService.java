package org.example.service;
public class MenuService {
//    public static void printMainMenu() {
//        System.out.println();
//        System.out.println("--------------MAIN MENU------------");
//        System.out.println("Choose your options:");
//        System.out.println("Enter    1     for enter your Login");
////        System.out.println("Enter    1     for enter as Doctor");
////        System.out.println("Enter    2    for enter as Patient");
//        System.out.println("Enter    2     for Exit");
//        System.out.println("------------------------------------");
//        System.out.print("Input options: ");
//    }

    public static void printMainMenu() {
        System.out.println();
        System.out.println("PRIVATE LIBRARY");
        System.out.println();
        System.out.println("If you wont quit, enter Exit");
        System.out.println();
        System.out.print("Enter your login: ");

////        System.out.println("Enter    1     for enter as Doctor");
////        System.out.println("Enter    2    for enter as Patient");
//        System.out.println("Enter    2     for Exit");
//        System.out.println("------------------------------------");
    }

    public static void printDoctorMenu() {
        System.out.println();
        System.out.println("-----------DOCTOR MENU---------------");
        System.out.println("Choose your options:");
        System.out.println("Enter     1    for Add Visit");
        System.out.println("Enter     2    for Delete Visit");
        System.out.println("Enter     3    for Cancel Visit");
        System.out.println("Enter     4    for Search Visit");
        System.out.println("Enter     5    for return in Main Menu");
        System.out.println("-------------------------------------");
        System.out.print("Input options: ");
    }

    public static void printPatientMenu() {
        System.out.println();
        System.out.println("-------------PATIENT MENU----------------");
        System.out.println("Choose your options:");
        System.out.println("Enter     1    for Show Visit");
        System.out.println("Enter     2    for Make appointment Visit");
        System.out.println("Enter     3    for Search Visit");
        System.out.println("Enter     4    for return in Main Menu");
        System.out.println("-----------------------------------------");
        System.out.print("Input options: ");
    }
}
