import java.util.Scanner;

/*
 * Program to check if the given date falls within the Spring season
 * Spring is from March 20 to June 20
 */
public class SpringSeasonChecker {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();
        System.out.print("Enter day: ");
        int day = input.nextInt();

        boolean isSpring = false;
        
        // Check conditions for Spring season
        if (month == 3 && day >= 20) isSpring = true;
        else if (month > 3 && month < 6) isSpring = true;
        else if (month == 6 && day <= 20) isSpring = true;

        // Display result
        if (isSpring) System.out.println("Its a Spring Season");
        else System.out.println("Not a Spring Season");

        // Close Scanner
        input.close();
    }
}