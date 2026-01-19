import java.util.Scanner;

/*
 * Program to check if a year is a Leap Year using multiple if-else statements
 */
public class LeapYear {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter year: ");
        int year = in.nextInt();

        // Check if year is valid
        if (year < 1582) {
            System.out.println("Year must be >= 1582 for Gregorian calendar checks.");
        } else {
            boolean isLeap = false;
            // Leap year logic
            if (year % 4 == 0) {
                if (year % 100 != 0) isLeap = true;
                else if (year % 400 == 0) isLeap = true;
            }
            
            // Display result
            if (isLeap) System.out.println(year + " is a Leap Year");
            else System.out.println(year + " is not a Leap Year");
        }

        // Close Scanner
        in.close();
    }
}
