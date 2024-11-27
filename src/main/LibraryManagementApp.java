package main;

import models.*;
import controllers.*;
import utils.*;

import java.util.*;

public class LibraryManagementApp {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        Admin admin = new Admin("Admin1", "A001");
        Member member = new Member("Member1", "M001");

        BookController bookController = new BookController();
        MemberController memberController = new MemberController();
        AdminController adminController = new AdminController();

        Scanner scanner = new Scanner(System.in);
        int choice;

        // Add some books initially
        Book book1 = new Book("Java Programming", "Author A", "12345");
        Book book2 = new Book("Python Programming", "Author B", "67890");
        adminController.addBook(admin, books, book1);
        adminController.addBook(admin, books, book2);

        // Menu loop
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display all books");
            System.out.println("2. Borrow a book (Member)");
            System.out.println("3. Return a book (Member)");
            System.out.println("4. Add a book (Admin)");
            System.out.println("5. Remove a book (Admin)");
            System.out.println("6. Generate Book Report (Admin)");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    // Display all books
                    bookController.displayBooks(books);
                    break;
                case 2:
                    // Borrow a book (Member)
                    System.out.print("Enter the ISBN of the book you want to borrow: ");
                    String borrowIsbn = scanner.nextLine();
                    Book bookToBorrow = bookController.searchBookByIsbn(borrowIsbn, books);
                    if (bookToBorrow != null) {
                        memberController.borrowBook(member, bookToBorrow);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    // Return a book (Member)
                    System.out.print("Enter the ISBN of the book you want to return: ");
                    String returnIsbn = scanner.nextLine();
                    Book bookToReturn = bookController.searchBookByIsbn(returnIsbn, books);
                    if (bookToReturn != null) {
                        memberController.returnBook(member, bookToReturn);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    // Add a book (Admin)
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    Book newBook = new Book(title, author, isbn);
                    adminController.addBook(admin, books, newBook);
                    break;
                case 5:
                    // Remove a book (Admin)
                    System.out.print("Enter the ISBN of the book to remove: ");
                    String removeIsbn = scanner.nextLine();
                    Book bookToRemove = bookController.searchBookByIsbn(removeIsbn, books);
                    if (bookToRemove != null) {
                        adminController.removeBook(admin, books, bookToRemove);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 6:
                    // Generate book report (Admin)
                    ReportGenerator.generateBookReport(books);
                    break;
                case 7:
                    // Exit
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;  // Exit the loop and terminate the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Pause after each action to let the user see the result
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();  // Wait for user to press Enter before continuing
        }
    }
}
