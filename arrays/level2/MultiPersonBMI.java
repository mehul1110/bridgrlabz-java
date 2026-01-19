import java.util.Scanner;

/*
 * Program to calculate BMI for multiple persons using a 2D array
 * Stores weight, height, and BMI for each person
 */
public class MultiPersonBMI {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int n = in.nextInt();
        
        // 2D Array: weight, height, bmi
        double[][] personData = new double[n][3];
        String[] status = new String[n];

        // Input and calculation loop
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            personData[i][0] = in.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            personData[i][1] = in.nextDouble();
            
            double h = personData[i][1] / 100.0;
            // Calculate BMI
            personData[i][2] = personData[i][0] / (h * h);
            
            double bmi = personData[i][2];
            
            // Determine weight status
            if (bmi <= 18.4) status[i] = "Underweight";
            else if (bmi <= 24.9) status[i] = "Normal";
            else if (bmi <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        // Display results
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d: weight=%.2f height=%.2f BMI=%.2f status=%s\n", i+1, personData[i][0], personData[i][1], personData[i][2], status[i]);
        }
        
        // Close Scanner
        in.close();
    }
}
