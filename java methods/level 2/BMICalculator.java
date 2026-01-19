import java.util.*;

/*
 * Program to calculate Body Mass Index (BMI) and determine weight status
 * It processes input for multiple persons using a 2D array
 */
public class BMICalculator {

    public static double computeBMI(double weightKg, double heightCm) {
        // Convert height from centimeters to meters
        double h = heightCm / 100.0;
        
        // Validate height
        if (h <= 0) return 0;
        
        // Calculate BMI using the formula: weight / (height * height)
        return weightKg / (h * h);
    }

    public static String bmiStatus(double bmi) {
        // Return status based on BMI range
        if (bmi <= 0) return "Invalid";
        if (bmi < 18.5) return "Underweight";
        if (bmi < 24.9) return "Normal";
        if (bmi < 29.9) return "Overweight";
        return "Obese";
    }

    public static void main(String[] args) {
        // Initialize Scanner for input
        Scanner sc = new Scanner(System.in);
        
        // Create 2D array to store weight, height, and BMI for 10 persons
        double[][] data = new double[10][3];
        
        System.out.println("Enter weight(kg) and height(cm) for 10 persons:");
        // Loop to get input for each person
        for (int i = 0; i < 10; i++) {
            System.out.print("Person " + (i + 1) + " weight(kg): ");
            data[i][0] = sc.nextDouble();
            System.out.print("Person " + (i + 1) + " height(cm): ");
            data[i][1] = sc.nextDouble();
            
            // Compute BMI and store it
            data[i][2] = computeBMI(data[i][0], data[i][1]);
        }
        
        // Display results
        for (int i = 0; i < 10; i++) {
            System.out.printf("Person %d: weight=%.2f kg, height=%.2f cm, BMI=%.2f, status=%s\n", i + 1, data[i][0], data[i][1], data[i][2], bmiStatus(data[i][2]));
        }
    }
}
