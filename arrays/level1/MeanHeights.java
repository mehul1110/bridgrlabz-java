import java.util.Scanner;

/*
 * Program to calculate the mean height of players in a football team
 * Stores heights in an array and computes average
 */
public class MeanHeights {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        // Array to store heights of 11 players
        double[] heights = new double[11];
        double sum = 0.0;
        
        // Input loop
        for (int i = 0; i < 11; i++) {
            System.out.print("Enter height for player " + (i + 1) + " (in cm): ");
            heights[i] = in.nextDouble();
            sum += heights[i];
        }
        
        // Calculate mean
        double mean = sum / 11.0;
        
        // Display result
        System.out.println("Mean height: " + mean);
        
        // Close Scanner
        in.close();
    }
}
