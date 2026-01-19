/*
 * This program calculates the length of a square's side
 * using the given perimeter value
 */
import java.util.Scanner;

public class SquareSideFromPerimeterCalculator {

    public static void main(String[] args) {

        // Create an input stream to read user input
        Scanner input = new Scanner(System.in);

        // Read perimeter value from the user
        System.out.print("Enter perimeter of the square: ");
        double perimeter = input.nextDouble();

        // Calculate side length using division
        double side = perimeter / 4.0;

        // Display the calculated side length
        System.out.println(
                "The length of the side is " + side +
                        " whose perimeter is " + perimeter
        );

        // Close the input stream
        input.close();
    }
}
