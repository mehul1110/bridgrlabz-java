import java.util.Scanner;

/*
 * Program to calculate Simple Interest
 * using the standard formula SI = (P * R * T) / 100
 */
public class SimpleInterest {

    public static double computeSimpleInterest(double principal, double rate, double time) {
        // Calculate simple interest using the formula (Principal * Rate * Time) / 100
        return principal * rate * time / 100.0;
    }

    public static void main(String[] args) {
        // Initialize Scanner for user input
        Scanner in = new Scanner(System.in);

        // Get the principal amount from user
        System.out.print("Enter principal: ");
        double p = in.nextDouble();

        // Get the rate of interest from user
        System.out.print("Enter rate (percent): ");
        double r = in.nextDouble();

        // Get the time period in years from user
        System.out.print("Enter time (years): ");
        double t = in.nextDouble();

        // Calculate the Simple Interest
        double si = computeSimpleInterest(p, r, t);

        // Display the calculated Simple Interest with formatted output
        System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f and Time %.2f\n", si, p, r, t);

        // Close the scanner
        in.close();
    }
}
