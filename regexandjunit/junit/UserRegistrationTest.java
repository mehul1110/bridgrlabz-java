package regexandjunit.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Logic Class
 */
class UserRegistration {
    public String register(String user, String email, String pass) {
        if (user == null || user.isEmpty())
            throw new IllegalArgumentException("Bad username");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Bad email");
        if (pass == null || pass.length() < 6)
            throw new IllegalArgumentException("Bad pass");
        return "Success";
    }
}

/**
 * JUnit Test Class
 */
public class UserRegistrationTest {
    UserRegistration reg = new UserRegistration();

    @Test
    void testRegistration() {
        assertEquals("Success", reg.register("john", "j@j.com", "secret123"));
        assertThrows(IllegalArgumentException.class, () -> reg.register("", "e", "p"));
    }
}
