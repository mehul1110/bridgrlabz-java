import java.util.Scanner;

/*
 * Program to calculate BMI for multiple persons and track their status using 2D arrays
 */
public class BMICalculatorTeam {

    // compute BMI and return status based on standard ranges
    public static String bmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25.0) return "Normal";
        if (bmi < 30.0) return "Overweight";
        return "Obese";
    }

    public static String[][] computeBMI(double[][] data) {
        int n = data.length;
        String[][] out = new String[n][4];
        
        // Loop through each person's data to calculate BMI
        for (int i = 0; i < n; i++) {
            double weight = data[i][0]; // kg 
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0; // Convert height to meters
            
            double bmi = 0.0;
            // Calculate BMI, ensuring no division by zero
            if (heightM > 0) {
                bmi = weight / (heightM * heightM);
            }
            
            // Populate output array with height, weight, BMI, and status
            out[i][0] = String.valueOf((int)heightCm);
            out[i][1] = String.valueOf((int)weight);
            out[i][2] = String.format("%.2f", bmi);
            out[i][3] = bmiStatus(bmi);
        }
        return out;
    }

    public static void display(String[][] table) {
        System.out.printf("%-8s %-8s %-8s %s%n", "Height", "Weight", "BMI", "Status");
        // Iterate through the results table to display each record
        for (String[] r : table) {
            System.out.printf("%-8s %-8s %-8s %s%n", r[0], r[1], r[2], r[3]);
        }
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            final int N = 10;
            double[][] data = new double[N][2];
            
            System.out.println("Enter weight (kg) and height (cm) for 10 persons:");
            // Loop to get input for 10 persons
            for (int i = 0; i < N; i++) {
                System.out.print("Person " + (i+1) + " weight kg: ");
                data[i][0] = sc.nextDouble();
                System.out.print("Person " + (i+1) + " height cm: ");
                data[i][1] = sc.nextDouble();
            }
            
            // Compute BMI stats
            String[][] table = computeBMI(data);
            
            // Display results
            display(table);
        }
    }
}
