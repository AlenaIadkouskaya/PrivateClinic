package org.example;

import org.example.model.*;
import org.example.service.VisitService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    private Utils() {
    }

    public static void showToConsole(List<Visit> listToShow) {
        System.out.println();
        System.out.println("LIST OF VISITS\n");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("|  ID  |    Data    |  Time  |            Doctor            |           Patient           |");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (Visit nextVisit : listToShow) {
            System.out.println("|" + Utils.addSpace(nextVisit.getId().toString(), 6) +
                    "|" + Utils.addSpace(nextVisit.getDate().toString(), 12) +
                    "|" + Utils.addSpace(nextVisit.getTime().toString(), 8) +
                    "|" + Utils.addSpace(nextVisit.getDoctor().toString(), 30) +
//                    "|" + Utils.addSpace((nextVisit.(Doctor)getDoctor().getId().toString(), 30) +
                    "|" + Utils.addSpace(nextVisit.getPatient() == null ? "-" : nextVisit.getPatient().toString(), 29) + "|");
        }
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    static String addSpace(String word, int lenghtString) {
        String retundWork = word;
        for (int i = 0; i < lenghtString - word.length(); i++) {
            retundWork = retundWork + " ";
        }
        return retundWork;
    }
}
