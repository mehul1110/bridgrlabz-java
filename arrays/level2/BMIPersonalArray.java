import java.util.Scanner;

/*
 * Program to calculate BMI for multiple persons using arrays
 * Prompts for weight and height, then computes and displays BMI
 */
public class BMIPersonalArray {

    public static void main(String[] args) {
        // Initialize Scanner for input
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int n = in.nextInt();
        
        // Arrays to store weight, height, and bmi
        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];

        // Loop to get input and calculate BMI
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            weight[i] = in.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            height[i] = in.nextDouble();
            
            // Convert height to meters
            double h = height[i] / 100.0;
            // Calculate BMI
            bmi[i] = weight[i] / (h * h);
        }

        // Loop to display results
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d: weight=%.2f height=%.2f BMI=%.2f\n", i+1, weight[i], height[i], bmi[i]);
        }
        
        // Close Scanner
        in.close();
    }
}
