package org.example;


import org.example.controller.UserController;
import org.example.model.Doctor;
import org.example.model.Specialization;
import org.example.model.Visit;
import org.example.service.LoginServiceImpl;
import org.example.service.SearchServiceImpl;
import org.example.service.VisitServiceImpl;

public class App {
    public static void main(String[] args) {
        UserController userController = new UserController();
//        LoginServiceImpl loginService = new LoginServiceImpl();
//        SearchServiceImpl searchService = new SearchServiceImpl();
//        VisitServiceImpl visitService = new VisitServiceImpl();

        userController.run();



    }

}
