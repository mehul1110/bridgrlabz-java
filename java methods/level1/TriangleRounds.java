import java.util.Scanner;

/*
 * Program to calculate rounds needed to cover a distance on a triangular track
 * handling the geometry and arithmetic of the problem
 */
public class TriangleRounds {

    public static double roundsForDistance(double side1, double side2, double side3, double distanceMeters) {
        // Calculate the perimeter of the triangle by summing its sides
        double perimeter = side1 + side2 + side3;

        // Check for invalid perimeter (must be positive)
        if (perimeter <= 0) return 0;

        // Calculate the number of rounds by dividing total distance by perimeter
        return distanceMeters / perimeter;
    }

    public static void main(String[] args) {
        // Create Scanner for reading input
        Scanner in = new Scanner(System.in);

        // Read the length of the first side
        System.out.print("Enter side1 (m): ");
        double s1 = in.nextDouble();

        // Read the length of the second side
        System.out.print("Enter side2 (m): ");
        double s2 = in.nextDouble();

        // Read the length of the third side
        System.out.print("Enter side3 (m): ");
        double s3 = in.nextDouble();

        // Calculate rounds needed for a 5km (5000m) run
        double rounds = roundsForDistance(s1, s2, s3, 5000.0);

        // Display the result formatted to 2 decimal places
        System.out.printf("Rounds needed to complete 5km: %.2f\n", rounds);

        // Close Scanner
        in.close();
    }
}
