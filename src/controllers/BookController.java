package controllers;

import models.Book;
import java.util.List;

public class BookController {

    public void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books available in the catalog.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public Book searchBookByIsbn(String isbn, List<Book> books) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;  // Return null if not found
    }
}
