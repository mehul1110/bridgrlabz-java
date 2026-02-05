package regexandjunit.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Logic Class
 */
class StringUtils {
    public String reverse(String str) {
        if (str == null)
            return null;
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str) {
        if (str == null)
            return false;
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    public String toUpperCase(String str) {
        return (str == null) ? null : str.toUpperCase();
    }
}

/**
 * JUnit Test Class
 */
public class StringUtilsTest {
    StringUtils utils = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("olleh", utils.reverse("hello"));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(utils.isPalindrome("madam"));
        assertFalse(utils.isPalindrome("java"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", utils.toUpperCase("hello"));
    }
}
