package project.exceptions;

public class StaffOrderException extends Exception{
    public StaffOrderException(String message) {
        super(message);
    }

    public StaffOrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public StaffOrderException(Throwable cause) {
        super(cause);
    }
}
