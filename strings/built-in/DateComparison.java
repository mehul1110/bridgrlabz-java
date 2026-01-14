import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Date1 (yyyy-MM-dd): ");
            LocalDate d1 = LocalDate.parse(sc.nextLine());
            System.out.print("Date2 (yyyy-MM-dd): ");
            LocalDate d2 = LocalDate.parse(sc.nextLine());
            if (d1.isBefore(d2)) System.out.println("Date1 is before Date2");
            else if (d1.isAfter(d2)) System.out.println("Date1 is after Date2");
            else System.out.println("Dates are equal");
        }
    }
}
