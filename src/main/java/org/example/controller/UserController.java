package org.example.controller;

import org.example.model.Doctor;
import org.example.model.User;
import org.example.model.Visit;
import org.example.service.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class UserController {
    private static final Scanner scanner = new Scanner(System.in);
    private final LoginService loginService = new LoginServiceImpl();

    public void run() {
        MenuService.printMainMenu();
        String inputLogin = scanner.nextLine();
        loginService.fakeUsers();
        User login = loginService.login(inputLogin);
        if (login instanceof Doctor) {
            doctorMenuOptions(login);
        } else {
            patientMenuOptions(login);
        }
        scanner.close();
    }

//    public void run() {
//        boolean mainMenu = true;
//        while (mainMenu) {
//            MenuService.printMainMenu();
//            String userOption = scanner.nextLine();
//            switch (userOption) {
//                case "1":
//                    User login = loginService.login("");
//                    if (login instanceof Doctor){
//                        doctorMenuOptions();
//                    } else {
//                        patientMenuOptions();
//                    }
//                    break;
////                case "2":
////                    patientMenuOptions();
////                    break;
//                case "2":
//                    mainMenu = false;
//                    break;
//                default:
//                    System.out.println("Invalid option. Please choose a valid option.");
//            }
//        }
//    }

    public static void doctorMenuOptions(User doctor) {
        VisitService visitService = new VisitServiceImpl();
        boolean doctorMenu = true;
        while (doctorMenu) {
            MenuService.printDoctorMenu();
            String userOption = scanner.nextLine().toLowerCase();
            switch (userOption) {
                case "1":
                    visitService.showVisit();
                    break;
                case "2":
                    System.out.print("Input year: ");
                    Integer year = scanner.nextInt();
                    System.out.print("Input month: ");
                    Integer month = scanner.nextInt();
                    System.out.print("Input day: ");
                    Integer day = scanner.nextInt();
                    System.out.print("Input hour: ");
                    Integer hour = scanner.nextInt();
                    System.out.print("Input minute: ");
                    Integer minute = scanner.nextInt();
                    scanner.nextLine();
                    visitService.addVisit(new Visit(LocalDate.of(year, month, day), LocalTime.of(hour, minute), doctor));
                    visitService.showVisit();

                    break;
                case "3":
                    visitService.showVisit();
                    System.out.print("Inpui id: ");
                    Integer id = scanner.nextInt();
                    scanner.nextLine();
                    visitService.deleteVisit(id);
                    break;
                case "4":
                    visitService.showVisit();
                    System.out.print("Input id: ");
                    Integer id2 = scanner.nextInt();
                    scanner.nextLine();
                    visitService.canselVisit(id2);
                    break;
                case "5":
                    //for Search Visit
                    break;
                case "6":
                    doctorMenu = false;
                    break;
                default:
                    throw new RuntimeException("Invalid option. Please choose a valid option.");
            }
        }
    }

    public static void patientMenuOptions(User patient) {
        VisitService visitService = new VisitServiceImpl();
        boolean patientMenu = true;
        while (patientMenu) {
            MenuService.printPatientMenu();
            String userOption = scanner.nextLine().toLowerCase();
            switch (userOption) {
                case "1":
                    visitService.showVisit();
                    break;
                case "2":
//                    visitService.makeAppointment();
                    break;
                case "3":
                    //search
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
