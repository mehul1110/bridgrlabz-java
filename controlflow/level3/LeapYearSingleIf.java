import java.util.Scanner;

/*
 * Program to check if a year is a Leap Year using a single if statement
 */
public class LeapYearSingleIf {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter year: ");
        int year = in.nextInt();

        // Check if year is valid
        if (year < 1582) {
            System.out.println("Year must be >= 1582 for Gregorian calendar checks.");
        } else {
            // Single line check for leap year
            boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            System.out.println(year + (isLeap ? " is a Leap Year" : " is not a Leap Year"));
        }

        // Close Scanner
        in.close();
    }
}
