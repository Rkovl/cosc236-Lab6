package lab5;

public class borrowingService implements BorrowingServiceAPI {

    @Override
    public BorrowingBookResult borrowBook(Member member, Book book) {
        BorrowingBookResult result = new BorrowingBookResult();
        if (book != null && book.getIsAvailable() && !member.getBorrowedBooks().contains(book) && member.borrowedBooksCount() < 3) {
            member.getBorrowedBooks().add(book);
            book.setIsAvailable(false);
            result.setBorrowingMessage("Borrowing book: " + book);
            result.setIsSuccess(true);
            return result;
        } else if (member.getBorrowedBooks().contains(book))
            result.setBorrowingMessage(member + " already borrowed: " + book);
        else if (book != null && !book.getIsAvailable())
            result.setBorrowingMessage(book + " is already borrowed by another member");
        else if (member.borrowedBooksCount() >= 3)
            result.setBorrowingMessage(member + " has too many books borrowed");

        result.setIsSuccess(false);
        return result;
    }

    @Override
    public BorrowingBookResult returnBook(Member member, Book book) {
        BorrowingBookResult result = new BorrowingBookResult();
        if (book != null && member.getBorrowedBooks().contains(book) && !book.getIsAvailable()) {
            member.getBorrowedBooks().remove(book);
            book.setIsAvailable(true);
            result.setBorrowingMessage("Returning book: " + book);
            result.setIsSuccess(true);
            return result;
        }
        else if (!member.getBorrowedBooks().contains(book))
            result.setBorrowingMessage(member + " does not have book: " + book);
        else if (book != null && book.getIsAvailable())
            result.setBorrowingMessage(book + " is already available");


        result.setIsSuccess(false);
        return result;

    }
}
