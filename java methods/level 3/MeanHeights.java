import java.util.Random;
import java.util.Scanner;

/*
 * Program to analyze heights of players in a football team
 * Calculates mean, shortest, and tallest heights
 */
public class MeanHeights {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        
        // Array to store heights
        double[] heights = new double[n];
        Random r = new Random();
        
        // Generate random heights between 150 and 250 cms
        for (int i = 0; i < n; i++) {
            heights[i] = 150 + r.nextInt(101); // 150..250
        }
        
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        
        // Iterate to calculate sum, min, and max
        for (double h : heights) {
            sum += h;
            if (h < min) min = h;
            if (h > max) max = h;
        }
        
        // Calculate mean height
        double mean = sum / n;
        
        // Display all heights
        System.out.println("Heights (cms):");
        for (int i = 0; i < n; i++) {
            System.out.printf("Player %d: %.0f\n", i + 1, heights[i]);
        }
        
        // Display statistics
        System.out.printf("Sum = %.0f\n", sum);
        System.out.printf("Mean = %.2f cms\n", mean);
        System.out.printf("Shortest = %.0f cms\n", min);
        System.out.printf("Tallest = %.0f cms\n", max);
        
        // Close Scanner
        sc.close();
    }
}
