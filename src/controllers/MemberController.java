package controllers;

import models.Member;
import models.Book;
import java.util.List;

public class MemberController {

    public void borrowBook(Member member, Book book) {
        member.borrowBook(book);
    }

    public void returnBook(Member member, Book book) {
        member.returnBook(book);
    }
}
