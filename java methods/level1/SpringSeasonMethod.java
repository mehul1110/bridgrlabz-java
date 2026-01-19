import java.util.Scanner;

/*
 * Program to determine if a given date corresponds to the Spring season
 * Spring is defined as being between March 20 and June 20
 */
public class SpringSeasonMethod {

    public static boolean isSpring(int month, int day) {
        // Check if the date is in March starting from day 20
        if (month == 3 && day >= 20) return true;

        // Check if the month is April or May (full months are in Spring)
        if (month > 3 && month < 6) return true;

        // Check if the date is in June up to day 20
        if (month == 6 && day <= 20) return true;

        // Return false if the date does not fall within the Spring season
        return false;
    }

    public static void main(String[] args) {
        // Initialize Scanner for reading input
        Scanner in = new Scanner(System.in);

        // Get month input from user
        System.out.print("Enter month (1-12): ");
        int m = in.nextInt();

        // Get day input from user
        System.out.print("Enter day: ");
        int d = in.nextInt();

        // Check if it is a Spring Season and display the result
        System.out.println(isSpring(m, d) ? "Its a Spring Season" : "Not a Spring Season");

        // Close Scanner
        in.close();
    }
}
