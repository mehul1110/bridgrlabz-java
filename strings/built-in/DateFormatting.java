import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * Program to demonstrate date formatting using DateTimeFormatter
 */
public class DateFormatting {

    public static void main(String[] args) {
        // Get current date
        LocalDate now = LocalDate.now();
        
        // Define formatters for different pattern requirements
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter f3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
        
        // Print formatted dates according to patterns
        System.out.println(now.format(f1));
        System.out.println(now.format(f2));
        System.out.println(now.format(f3));
    }
}
