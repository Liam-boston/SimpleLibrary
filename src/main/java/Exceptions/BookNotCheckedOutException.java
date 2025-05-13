package Exceptions;

public class BookNotCheckedOutException extends Exception {
    public BookNotCheckedOutException(String message) {
        super(message);
    }
}
