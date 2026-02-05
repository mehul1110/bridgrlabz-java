package regexandjunit.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Logic Class
 */
class PasswordValidator {
    public boolean isValid(String pw) {
        return pw != null && pw.length() >= 8 && !pw.equals(pw.toLowerCase()) && pw.matches(".*\\d.*");
    }
}

/**
 * JUnit Test Class
 */
public class PasswordValidatorTest {
    PasswordValidator validator = new PasswordValidator();

    @Test
    void testPasswords() {
        assertTrue(validator.isValid("SecureP4ssword"));
        assertFalse(validator.isValid("short"));
        assertFalse(validator.isValid("NoDigitUpper"));
    }
}
