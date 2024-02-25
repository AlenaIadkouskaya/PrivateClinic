package org.example.controller;

import org.example.Utils;
import org.example.exception.ExceptionLackOfVisit;
import org.example.model.Doctor;
import org.example.model.User;
import org.example.model.Visit;
import org.example.service.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class UserController {
    private static final Scanner scanner = new Scanner(System.in);
    private final LoginService loginService = new LoginServiceImpl();
    private final VisitServiceImpl visitService = new VisitServiceImpl();
    private final SearchService searchService = new SearchServiceImpl();

    public void run() {
        mainMenuOption(loginService);
    }

    private void mainMenuOption(LoginService loginService) {
        MenuService.printMainMenu();
        String inputLogin = scanner.nextLine();
        loginService.fakeUsers();
        User login = loginService.login(inputLogin);
        if (login instanceof Doctor) {
            doctorMenuOptions(login, loginService);
        } else {
            patientMenuOptions(login, loginService);
        }
//        scanner.close();
    }

    public void doctorMenuOptions(User doctor, LoginService loginService) {
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
                    int year = scanner.nextInt();
                    System.out.print("Input month: ");
                    int month = scanner.nextInt();
                    System.out.print("Input day: ");
                    int day = scanner.nextInt();
//                    MenuService.inputDate();
                    System.out.print("Input hour: ");
                    int hour = scanner.nextInt();
                    System.out.print("Input minute: ");
                    int minute = scanner.nextInt();
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
                    System.out.print("Input year: ");
                    int year1 = scanner.nextInt();
                    System.out.print("Input month: ");
                    int month1 = scanner.nextInt();
                    System.out.print("Input day: ");
                    int day1 = scanner.nextInt();
                    scanner.nextLine();
                    List<Visit> visits = searchService.searchVisit(LocalDate.of(year1, month1, day1), visitService.getListVisits());
                    Utils.showToConsole(visits);
                    break;
                case "6":
                    mainMenuOption(loginService);
                    break;
//                case "7":
//                    doctorMenu = false;
//                    break;
                default:
                    throw new ExceptionLackOfVisit("Invalid option. Please choose a valid option.");
            }
        }
    }

    public void patientMenuOptions(User patient, LoginService loginService) {
        boolean patientMenu = true;
        while (patientMenu) {
            MenuService.printPatientMenu();
            String userOption = scanner.nextLine().toLowerCase();
            switch (userOption) {
                case "1":
                    visitService.showVisit();
                    break;
                case "2":
                    visitService.showVisit();
                    System.out.print("Input id: ");
                    Integer id = scanner.nextInt();
                    scanner.nextLine();
                    visitService.makeAppointment(id, patient);
                    break;
                case "3":
                    System.out.print("Input year: ");
                    int year1 = scanner.nextInt();
                    System.out.print("Input month: ");
                    int month1 = scanner.nextInt();
                    System.out.print("Input day: ");
                    int day1 = scanner.nextInt();
//                    MenuService.inputDate();
                    scanner.nextLine();
                    List<Visit> visits = searchService.searchVisit(LocalDate.of(year1, month1, day1), visitService.getListVisits());
                    Utils.showToConsole(visits);
                    break;
                case "4":
                    mainMenuOption(loginService);
                    break;
//                case "5":
//                    patientMenu = false;
//                    break;
                default:
                    throw new ExceptionLackOfVisit("Invalid option. Please choose a valid option.");
            }
        }
    }
}
