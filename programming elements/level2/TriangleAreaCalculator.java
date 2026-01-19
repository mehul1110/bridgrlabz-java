/*
 * This program calculates the area of a triangle
 * and converts the result between units
 */
import java.util.Scanner;

public class TriangleAreaCalculator {

    public static void main(String[] args) {

        // Create an input stream to read user input
        Scanner input = new Scanner(System.in);

        // Read base and height values from the user
        System.out.print("Enter base in cm: ");
        double base = input.nextDouble();
        System.out.print("Enter height in cm: ");
        double height = input.nextDouble();

        // Calculate triangle area using the formula
        double areaCm2 = 0.5 * base * height;

        // Convert area from square centimeters to square inches
        double areaIn2 = areaCm2 / (2.54 * 2.54);

        // Display the calculated area values
        System.out.println(
                "The Area of the triangle in sq in is " + areaIn2 +
                        " and sq cm is " + areaCm2
        );

        // Close the input stream
        input.close();
    }
}
