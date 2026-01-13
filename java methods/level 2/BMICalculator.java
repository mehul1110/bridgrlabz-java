import java.util.*;

public class BMICalculator {
    public static double computeBMI(double weightKg, double heightCm) {
        double h = heightCm / 100.0;
        if (h <= 0) return 0;
        return weightKg / (h * h);
    }

    public static String bmiStatus(double bmi) {
        if (bmi <= 0) return "Invalid";
        if (bmi < 18.5) return "Underweight";
        if (bmi < 24.9) return "Normal";
        if (bmi < 29.9) return "Overweight";
        return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3];
        System.out.println("Enter weight(kg) and height(cm) for 10 persons:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Person " + (i + 1) + " weight(kg): ");
            data[i][0] = sc.nextDouble();
            System.out.print("Person " + (i + 1) + " height(cm): ");
            data[i][1] = sc.nextDouble();
            data[i][2] = computeBMI(data[i][0], data[i][1]);
        }
        for (int i = 0; i < 10; i++) {
            System.out.printf("Person %d: weight=%.2f kg, height=%.2f cm, BMI=%.2f, status=%s\n", i + 1, data[i][0], data[i][1], data[i][2], bmiStatus(data[i][2]));
        }
    }
}
