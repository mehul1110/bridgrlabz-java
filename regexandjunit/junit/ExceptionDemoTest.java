package regexandjunit.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Logic Class
 */
class ExceptionDemo {
    public int divide(int a, int b) {
        if (b == 0)
            throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }
}

/**
 * JUnit Test Class
 */
public class ExceptionDemoTest {
    ExceptionDemo demo = new ExceptionDemo();

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> demo.divide(10, 0));
    }
}
