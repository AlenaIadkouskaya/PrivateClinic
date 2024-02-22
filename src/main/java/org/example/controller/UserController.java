package org.example.controller;

import org.example.model.Doctor;
import org.example.model.User;
import org.example.service.LoginService;
import org.example.service.LoginServiceImpl;
import org.example.service.MenuService;

import java.util.Scanner;

public class UserController {
    private static final Scanner scanner = new Scanner(System.in);

    private final LoginService loginService = new LoginServiceImpl();

//    public UserController(MenuService menuService, Scanner scanner) {
//        this.menuService = new MenuService();
//        this.scanner = new Scanner(System.in);
//    }

    //    public void run() {
//        MenuService.printMainMenu();
//        String userOption = scanner.nextLine();
//        if (userOption.equalsIgnoreCase("doctor")) {
//            MenuService.printDoctorMenu();
//            String userOptionDoctor = scanner.nextLine();
//            MenuService.doctorMenuOptions(userOptionDoctor);
//        }
//        if (userOption.equalsIgnoreCase("patient")) {
//            MenuService.printPatientMenu();
//            String userOptionPatient = scanner.nextLine();
//            MenuService.patientMenuOptions(userOptionPatient);
//        }
//        scanner.close();
//    }

    public void run() {
        boolean mainMenu = true;
        while (mainMenu) {
            MenuService.printMainMenu();
            String userOption = scanner.nextLine();
            switch (userOption) {
                case "1":
                    User login = loginService.login("");
                    if (login instanceof Doctor){
                        //menu doctor
                    } else {
                        //menu patient
                    }


                    doctorMenuOptions();
                    break;
                case "2":
                    patientMenuOptions();
                    break;
                case "exit":
                    mainMenu = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    public static void doctorMenuOptions() {
        boolean doctorMenu = true;
        while (doctorMenu) {
            MenuService.printDoctorMenu();
            String userOption = scanner.nextLine().toLowerCase();
            switch (userOption) {
                case "1":
                    // addVisit
                    break;
                case "2":
                    // deleteVisit
                    break;
                case "3":
                    // canselVisit
                    break;
                case "4":
                    //for Search Visit
                    break;
                case "5":
                    doctorMenu = false;
                    break;
                default:
                    throw new RuntimeException("Invalid option. Please choose a valid option.");
            }
        }
    }

    public static void patientMenuOptions() {
        boolean patientMenu = true;
        while (patientMenu) {
            MenuService.printPatientMenu();
            String userOption = scanner.nextLine().toLowerCase();
            switch (userOption) {
                case "1":
                    // showVisit
                    break;
                case "2":
                    //
                    break;
                case "3":
                    //
                    break;
                case "4":
                    patientMenu = false;
                    break;
                default:
                    throw new RuntimeException("Invalid option. Please choose a valid option.");
            }
        }
    }
}
