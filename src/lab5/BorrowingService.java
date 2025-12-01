package lab5;

public class BorrowingService implements BorrowingServiceAPI {
    private static BorrowingService instance;
    private int borrowingLimit;

    private BorrowingService() {
        borrowingLimit = 3;
    }

    public static synchronized BorrowingService getInstance() {
        if (instance == null) {
            instance = new BorrowingService();
        }
        return instance;
    }

    @Override
    public BorrowingBookResult borrowBook(Member member, Book book) {
        // Implement real logic or leave as a stub for now
        return new BorrowingBookResult(true, "Borrowed (stub)");
    }

    @Override
    public BorrowingBookResult returnBook(Member member, Book book) {
        // Implement real logic or leave as a stub for now
        return new BorrowingBookResult(true, "Returned (stub)");
    }
}
