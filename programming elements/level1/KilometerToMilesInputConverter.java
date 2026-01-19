/*
 * This program converts a distance value
 * from kilometers to miles using user input
 */
import java.util.Scanner;

public class KilometerToMilesInputConverter {

    public static void main(String[] args) {

        // Create an input stream to accept user data
        Scanner input = new Scanner(System.in);

        // Read numeric input from the user
        System.out.print("Enter distance in km: ");
        double km = input.nextDouble();

        // Convert kilometers to miles using division
        double miles = km / 1.6;

        // Display the converted distance
        System.out.println(
                "The total miles is " + miles +
                        " mile for the given " + km + " km"
        );

        // Close the input stream
        input.close();
    }
}
