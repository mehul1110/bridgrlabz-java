package regexandjunit.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Logic Class
 */
class MathUtils {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}

/**
 * JUnit Test Class
 */
public class MathUtilsTest {
    MathUtils math = new MathUtils();

    @ParameterizedTest
    @ValueSource(ints = { 2, 4, 6, 8, 10 })
    void testIsEven(int number) {
        assertTrue(math.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, 7, 9 })
    void testIsOdd(int number) {
        assertFalse(math.isEven(number));
    }
}
