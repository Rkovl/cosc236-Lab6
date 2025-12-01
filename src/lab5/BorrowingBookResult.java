package lab5;

public class BorrowingBookResult {
    private boolean isSuccess;
    private String borrowingMessage;

    public BorrowingBookResult(boolean isSuccess, String borrowingMessage) {
        this.isSuccess = isSuccess;
        this.borrowingMessage = borrowingMessage;
    }

    public BorrowingBookResult() {
        this.isSuccess = false;
        this.borrowingMessage = "Default";
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getBorrowingMessage() {
        return borrowingMessage;
    }

    public void setBorrowingMessage(String borrowingMessage) {
        this.borrowingMessage = borrowingMessage;
    }
}
