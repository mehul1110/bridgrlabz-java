import java.util.Scanner;

/*
 * Program to calculate BMI and determine weight status
 */
public class BMI {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter weight (kg): ");
        double w = in.nextDouble();
        System.out.print("Enter height (cm): ");
        double hcm = in.nextDouble();

        // Convert height to meters
        double h = hcm / 100.0;
        // Calculate BMI
        double bmi = w / (h * h);

        String status;
        // Determine status
        if (bmi <= 18.4) status = "Underweight";
        else if (bmi <= 24.9) status = "Normal";
        else if (bmi <= 39.9) status = "Overweight";
        else status = "Obese";

        // Display results
        System.out.printf("BMI: %.2f - %s\n", bmi, status);
        
        // Close Scanner
        in.close();
    }
}
