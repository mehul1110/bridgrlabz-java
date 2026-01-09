import java.util.Scanner;

public class BMIPersonalArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = in.nextInt();
        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            weight[i] = in.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            height[i] = in.nextDouble();
            double h = height[i] / 100.0;
            bmi[i] = weight[i] / (h * h);
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d: weight=%.2f height=%.2f BMI=%.2f\n", i+1, weight[i], height[i], bmi[i]);
        }
        in.close();
    }
}
