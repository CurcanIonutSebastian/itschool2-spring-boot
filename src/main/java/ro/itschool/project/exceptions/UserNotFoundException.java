package ro.itschool.project.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}