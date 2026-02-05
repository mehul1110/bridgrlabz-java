package regexandjunit.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Logic Class (Non-public to reside in the same file)
 */
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0)
            throw new ArithmeticException("Division by zero");
        return a / b;
    }
}

/**
 * JUnit Test Class
 */
public class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(10, calc.add(7, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(4, calc.subtract(7, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(21, calc.multiply(7, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2, calc.divide(6, 3));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
    }
}
