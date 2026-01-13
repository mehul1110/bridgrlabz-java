import java.util.Random;
import java.util.Scanner;

public class MeanHeights {
    // Q1: find shortest, tallest and mean height of players in a football team
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        double[] heights = new double[n];
        Random r = new Random();
        // generate 3-digit heights in cms between 150 and 250
        for (int i = 0; i < n; i++) {
            heights[i] = 150 + r.nextInt(101); // 150..250
        }
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double h : heights) {
            sum += h;
            if (h < min) min = h;
            if (h > max) max = h;
        }
        double mean = sum / n;
        System.out.println("Heights (cms):");
        for (int i = 0; i < n; i++) {
            System.out.printf("Player %d: %.0f\n", i + 1, heights[i]);
        }
        System.out.printf("Sum = %.0f\n", sum);
        System.out.printf("Mean = %.2f cms\n", mean);
        System.out.printf("Shortest = %.0f cms\n", min);
        System.out.printf("Tallest = %.0f cms\n", max);
        sc.close();
    }
}
