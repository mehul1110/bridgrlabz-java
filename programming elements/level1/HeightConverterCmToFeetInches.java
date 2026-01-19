/*
 * This program converts a height value
 * from centimeters to feet and inches
 */
import java.util.Scanner;

public class HeightConverterCmToFeetInches {

    public static void main(String[] args) {

        // Create an input stream to read user input
        Scanner input = new Scanner(System.in);

        // Accept height value from the user
        System.out.print("Enter height in cm: ");
        double cm = input.nextDouble();

        // Convert centimeters to inches using division
        double totalInches = cm / 2.54;

        // Convert total inches into feet using type casting and division
        int feet = (int) totalInches / 12;

        // Calculate remaining inches after extracting feet
        double inches = totalInches - (feet * 12);

        // Display the converted height values
        System.out.println(
                "Your Height in cm is " + cm +
                        " while in feet is " + feet +
                        " and inches is " + inches
        );

        // Close the input stream
        input.close();
    }
}
