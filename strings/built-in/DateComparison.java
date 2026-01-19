import java.time.LocalDate;
import java.util.Scanner;

/*
 * Program to compare two dates entered by the user
 */
public class DateComparison {

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Date1 (yyyy-MM-dd): ");
            // Parse first date
            LocalDate d1 = LocalDate.parse(sc.nextLine());
            
            System.out.print("Date2 (yyyy-MM-dd): ");
            // Parse second date
            LocalDate d2 = LocalDate.parse(sc.nextLine());
            
            // Compare dates to see which comes first
            if (d1.isBefore(d2)) {
                System.out.println("Date1 is before Date2");
            } else if (d1.isAfter(d2)) {
                System.out.println("Date1 is after Date2");
            } else {
                System.out.println("Dates are equal");
            }
        }
    }
}
