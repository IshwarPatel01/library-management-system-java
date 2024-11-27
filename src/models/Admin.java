package models;

import java.util.List;

public class Admin extends Member {

    public Admin(String name, String memberId) {
        super(name, memberId);
    }

    public void addBook(List<Book> books, Book book) {
        books.add(book);
        System.out.println("Admin added the book: " + book.getTitle());
    }

    public void removeBook(List<Book> books, Book book) {
        books.remove(book);
        System.out.println("Admin removed the book: " + book.getTitle());
    }
}
