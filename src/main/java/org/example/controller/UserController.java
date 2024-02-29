package org.example.controller;

import org.example.Utils;
import org.example.model.Doctor;
import org.example.model.User;
import org.example.model.Visit;
import org.example.service.*;

import java.lang.module.FindException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserController {
    private Scanner scanner;
    private final LoginService loginService;
    private final VisitService visitService;
    private final FileService fileService;

    public UserController(LoginService loginService, VisitService visitService, FileService fileService, Scanner scanner) {
        this.loginService = loginService;
        this.visitService = visitService;
        this.fileService = fileService;
        this.scanner = scanner;
    }

    public void run() {
        scanner = new Scanner(System.in);
        List<User> listOfUsers = fileService.getUsersFromFile();
        loginService.setUsers(listOfUsers);
        Map<LocalDate, List<Visit>> visitsFromFile = fileService.getVisitsFromFile();
        visitService.setListVisits(visitsFromFile);
        mainMenuOption(loginService);
        scanner.close();
    }

    //    public void newUser(Scanner scanner){
//        System.out.print("Input Name: ");
//        String name = scanner.nextLine();
//        System.out.print("Input Surname: ");
//        String surname = scanner.nextLine();
//        System.out.print("Input Login: ");
//        System.out.print("Input Password: ");
//        String password = scanner.nextLine();
//        System.out.print("Input Number Telephone: ");
//        String telephone = scanner.nextLine();
//    }

    private void mainMenuOption(LoginService loginService) {
        User login = null;
        while (login == null) {
            MenuService.printMainMenu();
            String inputLogin = scanner.nextLine();
            System.out.print("Enter your password: ");
            String inputPassword = scanner.nextLine();
            try {
                login = loginService.login(inputLogin, inputPassword);
                if (login instanceof Doctor) {
                    doctorMenuOptions(login, loginService);
                } else {
                    patientMenuOptions(login, loginService);
                }
            } catch (FindException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void doctorMenuOptions(User doctor, LoginService loginService) {
        SearchService searchService = new SearchServiceImpl();
        while (true) {
            try {
                MenuService.printDoctorMenu(doctor);
                String userOption = scanner.nextLine().toLowerCase();
                switch (userOption) {
                    case "1":
                        visitService.showVisit();
                        break;
                    case "2":
                        visitService.addVisit(new Visit(getLocalDateFromConsole(scanner), getLocalTimeFromConsole(scanner), doctor));
                        visitService.showVisit();
                        break;
                    case "3":
                        visitService.showVisit();
                        System.out.print("Inpui id: ");
                        Integer id = scanner.nextInt();
                        scanner.nextLine();
                        visitService.deleteVisit(id);
                        visitService.showVisit();
                        break;
                    case "4":
                        visitService.showVisit();
                        System.out.print("Input id: ");
                        Integer id2 = scanner.nextInt();
                        scanner.nextLine();
                        visitService.canselVisit(id2);
                        visitService.showVisit();
                        break;
                    case "5":
                        List<Visit> visits = searchService.searchVisit(getLocalDateFromConsole(scanner), visitService.getListVisits());
                        Utils.showToConsole(visits);
                        break;
                    case "6":
                        mainMenuOption(loginService);
                        break;
                    case "7":
                        fileService.writeToFileUsers(loginService.getUsers());
                        fileService.writeToFileVisits(visitService.getListVisits());
                        System.exit(0);
                        break;
                    default:
                        throw new RuntimeException("Invalid option. Please choose a valid option.");
                }
            } catch (FindException e) {
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("Input correct number menu");
            }
        }
    }

    private void patientMenuOptions(User patient, LoginService loginService) {
        SearchService searchService = new SearchServiceImpl();
        while (true) {
            try {
                MenuService.printPatientMenu(patient);
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
                        visitService.showVisit();
                        break;
                    case "3":
                        List<Visit> visits = searchService.searchVisit(getLocalDateFromConsole(scanner), visitService.getListVisits());
                        Utils.showToConsole(visits);
                        break;
                    case "4":
                        mainMenuOption(loginService);
                        break;
                    case "5":
                        fileService.writeToFileUsers(loginService.getUsers());
                        fileService.writeToFileVisits(visitService.getListVisits());
                        System.exit(0);
                        break;
                    default:
                        throw new RuntimeException("Invalid option. Please choose a valid option.");
                }
            } catch (FindException e) {
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("Input correct number menu");
            }
        }
    }

    private LocalTime getLocalTimeFromConsole(Scanner scanner) {
        System.out.print("Input hour: ");
        int hour = scanner.nextInt();
        System.out.print("Input minute: ");
        int minute = scanner.nextInt();
        scanner.nextLine();
        return LocalTime.of(hour, minute);
    }

    private static LocalDate getLocalDateFromConsole(Scanner scanner) {
        System.out.print("Input year: ");
        int year = scanner.nextInt();
        System.out.print("Input month: ");
        int month = scanner.nextInt();
        System.out.print("Input day: ");
        int day = scanner.nextInt();
        LocalDate receiveDate = LocalDate.of(year, month, day);
        scanner.nextLine();
        return receiveDate;
    }
}
