package org.example;

import org.example.model.*;
import java.util.List;

public class Utils {
    private Utils() {
    }

    public static void showToConsole(List<Visit> listToShow) {
        System.out.println();
        System.out.println("LIST OF VISITS\n");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("|  ID  |    Data    |  Time  |            Doctor            |   Specialization   |           Patient           |");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        for (Visit nextVisit : listToShow) {
            Doctor doctor = (Doctor) nextVisit.getDoctor();
            System.out.println("|" + Utils.addSpace(nextVisit.getId().toString(), 6) +
                    "|" + Utils.addSpace(nextVisit.getDate().toString(), 12) +
                    "|" + Utils.addSpace(nextVisit.getTime().toString(), 8) +
                    "|" + Utils.addSpace(doctor.toString(), 30) +
                    "|" + Utils.addSpace((doctor.getSpecialization().toString()), 20) +
                    "|" + Utils.addSpace(nextVisit.getPatient() == null ? "-" : nextVisit.getPatient().toString(), 29) + "|");
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }

    static String addSpace(String word, int lenghtString) {
        String retundWork = word;
        for (int i = 0; i < lenghtString - word.length(); i++) {
            retundWork = retundWork + " ";
        }
        return retundWork;
    }
}
