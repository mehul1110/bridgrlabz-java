package exceptions;

/**
 * Problem Statement 3: Throw and Throws
 * 
 * Problem: UserService registration.
 * 1. registerUser throws UserAlreadyExistsException.
 * 2. checkUserExistence throws UserNotFoundException.
 */

class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

public class UserService {

    public void registerUser(String username) throws UserAlreadyExistsException {
        if ("existing".equals(username)) {
            throw new UserAlreadyExistsException("User already exists!");
        }
        System.out.println("Registering " + username);
    }

    public void checkUserExistence(String username) throws UserNotFoundException {
        if (!"existing".equals(username)) {
            throw new UserNotFoundException("User not found!");
        }
        System.out.println("User found.");
    }

    public static void main(String[] args) {
        UserService service = new UserService();

        try {
            service.registerUser("existing");
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {
            service.checkUserExistence("unknown");
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
