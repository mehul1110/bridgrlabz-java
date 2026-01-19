/*
 * This program converts a distance value
 * from feet to yards and miles
 */
import java.util.Scanner;

public class FeetToYardsAndMilesConverter {

    public static void main(String[] args) {

        // Create an input stream to read user input
        Scanner input = new Scanner(System.in);

        // Read distance value from the user
        System.out.print("Enter distance in feet: ");
        double feet = input.nextDouble();

        // Convert feet to yards using division
        double yards = feet / 3.0;

        // Convert yards to miles using division
        double miles = yards / 1760.0;

        // Display the converted distance values
        System.out.println(
                "The distance in yards is " + yards +
                        " while the distance in miles is " + miles
        );

        // Close the input stream
        input.close();
    }
}
