import java.util.Scanner;

public class MultiPersonBMI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = in.nextInt();
        double[][] personData = new double[n][3]; // weight, height, bmi
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            personData[i][0] = in.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            personData[i][1] = in.nextDouble();
            double h = personData[i][1] / 100.0;
            personData[i][2] = personData[i][0] / (h * h);
            double bmi = personData[i][2];
            if (bmi <= 18.4) status[i] = "Underweight";
            else if (bmi <= 24.9) status[i] = "Normal";
            else if (bmi <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d: weight=%.2f height=%.2f BMI=%.2f status=%s\n", i+1, personData[i][0], personData[i][1], personData[i][2], status[i]);
        }
        in.close();
    }
}
