package project.exceptions;

public class CustomDuplicateKeyException extends RuntimeException{
    public CustomDuplicateKeyException(String message) {
        super(message);
    }
}
