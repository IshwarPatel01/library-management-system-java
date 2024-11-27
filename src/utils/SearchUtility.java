package utils;

import models.Book;
import java.util.List;

public class SearchUtility {

    public static Book searchBookByIsbn(String isbn, List<Book> books) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}
