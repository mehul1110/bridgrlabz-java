package regexandjunit.junit;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Logic Class
 */
class DateFormatter {
    public String formatDate(String input) {
        LocalDate date = LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}

/**
 * JUnit Test Class
 */
public class DateFormatterTest {
    DateFormatter formatter = new DateFormatter();

    @Test
    void testFormat() {
        assertEquals("04-12-2023", formatter.formatDate("2023-12-04"));
        assertThrows(Exception.class, () -> formatter.formatDate("invalid"));
    }
}
