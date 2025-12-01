package lab5.tests;

import lab5.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBorrowingService {

    @Test
    void testAlreadyBorrowed() {
        borrowingService borrowService = new borrowingService();
        Book book = new PaperBook("Dune");
        Member member = new Member("Bob");
        borrowService.borrowBook(member, book);

        BorrowingBookResult result = borrowService.borrowBook(member, book);
        assertFalse(result.getIsSuccess());
    }
    @Test
    void testAlreadyBorrowedByOtherMember() {
        borrowingService borrowService = new borrowingService();
        Book book = new PaperBook("Dune");
        Member member = new Member("Bob");
        Member member2 = new Member("Herb");

        borrowService.borrowBook(member, book);
        BorrowingBookResult result = borrowService.borrowBook(member2, book);
        assertFalse(result.getIsSuccess());
    }
    @Test
    void testTooManyBooks() {
        borrowingService borrowService = new borrowingService();
        Book book1 = new PaperBook("Dune");
        Book book2 = new PaperBook("Dune 2");
        Book book3 = new PaperBook("Dune 3");
        Book book4 = new PaperBook("Failure");

        Member member = new Member("Bob");
        borrowService.borrowBook(member, book1);
        borrowService.borrowBook(member, book2);
        borrowService.borrowBook(member, book3);

        BorrowingBookResult result = borrowService.borrowBook(member, book4);
        assertFalse(result.getIsSuccess());
    }
    @Test
    void testHasntBeenBorrowed() {
        borrowingService borrowService = new borrowingService();
        Book book1 = new PaperBook("Dune");
        Member member = new Member("Bob");
        book1.setIsAvailable(false);
        BorrowingBookResult result = borrowService.returnBook(member, book1);

        assertFalse(result.getIsSuccess());
    }
    @Test
    void testAlreadyAvailable() {
        borrowingService borrowService = new borrowingService();
        Book book1 = new PaperBook("Dune");
        Member member = new Member("Bob");
        BorrowingBookResult result = borrowService.returnBook(member, book1);

        assertFalse(result.getIsSuccess());
    }
}
