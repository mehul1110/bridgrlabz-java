import java.util.Scanner;
import java.util.Arrays;

/*
 * Program to calculate trigonometric functions
 * Computes sine, cosine, and tangent for an input angle in degrees
 */
public class TrigFunctions {

    public static double[] calculateTrigonometricFunctions(double angleDegrees) {
        // Convert the angle from degrees to radians
        double rad = Math.toRadians(angleDegrees);

        // Calculate the sine of the angle
        double sin = Math.sin(rad);

        // Calculate the cosine of the angle
        double cos = Math.cos(rad);

        // Calculate the tangent of the angle
        double tan = Math.tan(rad);

        // Return the trigonometric values in an array
        return new double[]{sin, cos, tan};
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner in = new Scanner(System.in);

        // Prompt user for angle in degrees
        System.out.print("Enter angle in degrees: ");
        double a = in.nextDouble();

        // Perform trigonometric calculations
        double[] res = calculateTrigonometricFunctions(a);

        // Display the results
        System.out.printf("sin=%.4f cos=%.4f tan=%.4f\n", res[0], res[1], res[2]);

        // Close Scanner
        in.close();
    }
}
