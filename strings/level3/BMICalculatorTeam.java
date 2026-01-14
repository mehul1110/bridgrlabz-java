import java.util.Scanner;

public class BMICalculatorTeam {
    // compute BMI and return status
    public static String bmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25.0) return "Normal";
        if (bmi < 30.0) return "Overweight";
        return "Obese";
    }

    public static String[][] computeBMI(double[][] data) {
        int n = data.length;
        String[][] out = new String[n][4];
        for (int i = 0; i < n; i++) {
            double weight = data[i][0]; // kg
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;
            double bmi = 0.0;
            if (heightM > 0) bmi = weight / (heightM * heightM);
            out[i][0] = String.valueOf((int)heightCm);
            out[i][1] = String.valueOf((int)weight);
            out[i][2] = String.format("%.2f", bmi);
            out[i][3] = bmiStatus(bmi);
        }
        return out;
    }

    public static void display(String[][] table) {
        System.out.printf("%-8s %-8s %-8s %s%n", "Height", "Weight", "BMI", "Status");
        for (String[] r : table) {
            System.out.printf("%-8s %-8s %-8s %s%n", r[0], r[1], r[2], r[3]);
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final int N = 10;
            double[][] data = new double[N][2];
            System.out.println("Enter weight (kg) and height (cm) for 10 persons:");
            for (int i = 0; i < N; i++) {
                System.out.print("Person " + (i+1) + " weight kg: ");
                data[i][0] = sc.nextDouble();
                System.out.print("Person " + (i+1) + " height cm: ");
                data[i][1] = sc.nextDouble();
            }
            String[][] table = computeBMI(data);
            display(table);
        }
    }
}
