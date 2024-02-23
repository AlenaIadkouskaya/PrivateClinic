package org.example.service;


public class MenuService {
    public static void mainMenuOptions(String userOption) {
        switch (userOption) {
            case "1":
                printDoctorMenu();
            case "2":
                printPatientMenu();
                break;
            default:
                throw new RuntimeException("Invalid option. Please choose a valid option.");
        }
    }

    public void doctorMenuOptions(String userOption) {
        switch (userOption) {
            case "1":

                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            default:
                throw new RuntimeException("Invalid option. Please choose a valid option.");
        }
    }

    public void patientMenuOptions(String userOption) {
        switch (userOption) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            default:
                throw new RuntimeException("Invalid option. Please choose a valid option.");
        }
    }

    public static void printMainMenu() {
        System.out.println();
        System.out.println("--------------MAIN MENU------------");
        System.out.println("Choose your options:");
        System.out.println("Enter     1    for enter as Doctor");
        System.out.println("Enter     2    for enter as Patient");
        System.out.println("Enter    EXIT   for Quit");
//        System.out.println("-----------------------------------");
        System.out.print("Input options: ");
    }

    public static void printDoctorMenu() {
        System.out.println();
        System.out.println("-----------DOCTOR MENU---------------");
        System.out.println("Choose your options:");
        System.out.println("Enter     1    for Add Visit");
        System.out.println("Enter     2    for Delete Visit");
        System.out.println("Enter     3    for Cancel Visit");
        System.out.println("Enter     4    for Search Visit");
        System.out.println("Enter     5    for Enter in Main Menu");
        System.out.println("-------------------------------------");
        System.out.print("Input options: ");
    }

    public static void printPatientMenu() {
        System.out.println();
        System.out.println("-----------PATIENT MENU---------------");
        System.out.println("Choose your options:");
        System.out.println("Enter     1    for Show Visit");
        System.out.println("Enter     2    for Make appointment Visit");
        System.out.println("Enter     3    for Search Visit");
        System.out.println("Enter     4    for Enter in Main Menu");
        System.out.println("-------------------------------------");
        System.out.print("Input options: ");
    }

}
