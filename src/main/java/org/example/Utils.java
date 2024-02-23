package org.example;

import org.example.model.Visit;

import java.util.List;
import java.util.Map;

public class Utils {
    private Utils() {
    }

    static void showToConsole(List<Visit> listToShow) {
        System.out.println("LIST OF VISITS\n");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|            ID            |             Data            |  Time  | Doctor |");
        System.out.println("---------------------------------------------------------------------------------");
        for (Book nextBook : listToShow) {
            System.out.println("|" + Utils.addSpace(nextBook.getAuthor().getNameAuthor(), 30) +
                    "|" + Utils.addSpace(nextBook.getTitle(), 30) +
                    "|" + Utils.addSpace(nextBook.getYear().toString(), 8) +
                    "|" + Utils.addSpace(nextBook.getStatus().toString(), 8) + "|" + nextBook.getId());
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    private static void printListOfReaders(Map<Reader, List<Book>> listReaders) {
        System.out.println("LIST OF READERS\n");
        for (Map.Entry<Reader, List<Book>> pair : listReaders.entrySet()) {
            Reader reader = pair.getKey();
            List<Book> listRedersBooks = pair.getValue();
            String readersBooks = listRedersBooks.toString();
            System.out.println(reader + " : " + readersBooks);
        }
    }
}
