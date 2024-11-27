package utils;

import models.Book;
import java.util.List;

public class ReportGenerator {

    public static void generateBookReport(List<Book> books) {
        System.out.println("Generating Book Report...");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
