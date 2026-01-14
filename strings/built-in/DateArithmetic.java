import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter date (yyyy-MM-dd): ");
            String in = sc.nextLine();
            LocalDate d = LocalDate.parse(in);
            LocalDate r = d.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
            System.out.println("Result: " + r);
        }
    }
}
