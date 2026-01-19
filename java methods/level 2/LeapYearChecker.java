import java.util.*;

/*
 * Program to check if a year is a Leap Year
 * Follows the rules of the Gregorian calendar
 */
public class LeapYearChecker {

    public static boolean isLeapYear(int year) {
        // Gregorian calendar started in 1582
        if (year < 1582) return false;
        
        // A year is a leap year if divisible by 4 but not 100
        boolean a = (year % 4 == 0) && (year % 100 != 0);
        
        // Or if it is divisible by 400
        boolean b = (year % 400 == 0);
        
        return a || b;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a year (>=1582): ");
        int y = sc.nextInt();
        
        // Validate year input
        if (y < 1582) {
            System.out.println("Year must be >= 1582 for Gregorian calendar.");
            return;
        }
        
        // Check and display result
        System.out.println(y + (isLeapYear(y) ? " is a Leap Year" : " is not a Leap Year"));
    }
}
