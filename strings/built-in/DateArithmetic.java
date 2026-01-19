import java.time.LocalDate;
import java.util.Scanner;

/*
 * Program to perform arithmetic operations on dates using LocalDate
 */
public class DateArithmetic {

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter date (yyyy-MM-dd): ");
            String in = sc.nextLine();
            
            // Parse the input string to a LocalDate object
            LocalDate d = LocalDate.parse(in);
            
            // Perform date calculations: add 7 days, then 1 month, then 2 years, then subtract 3 weeks
            LocalDate r = d.plusDays(7)
                           .plusMonths(1)
                           .plusYears(2)
                           .minusWeeks(3);
            
            System.out.println("Result: " + r);
        }
    }
}
