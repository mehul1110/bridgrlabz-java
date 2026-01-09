import java.util.Scanner;

public class MeanHeights {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;
        for (int i = 0; i < 11; i++) {
            System.out.print("Enter height for player " + (i + 1) + " (in cm): ");
            heights[i] = in.nextDouble();
            sum += heights[i];
        }
        double mean = sum / 11.0;
        System.out.println("Mean height: " + mean);
        in.close();
    }
}
