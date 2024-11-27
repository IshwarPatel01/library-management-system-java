package controllers;

import models.Admin;
import models.Book;
import java.util.List;

public class AdminController {

    public void addBook(Admin admin, List<Book> books, Book book) {
        admin.addBook(books, book);
    }

    public void removeBook(Admin admin, List<Book> books, Book book) {
        admin.removeBook(books, book);
    }
}
