package regexandjunit.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Logic Class
 */
class TemperatureConverter {
    public double cToF(double c) {
        return (c * 9 / 5) + 32;
    }

    public double fToC(double f) {
        return (f - 32) * 5 / 9;
    }
}

/**
 * JUnit Test Class
 */
public class TemperatureConverterTest {
    TemperatureConverter conv = new TemperatureConverter();

    @Test
    void testConversion() {
        assertEquals(32, conv.cToF(0), 0.001);
        assertEquals(0, conv.fToC(32), 0.001);
    }
}
