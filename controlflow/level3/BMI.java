import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter weight (kg): ");
        double w = in.nextDouble();
        System.out.print("Enter height (cm): ");
        double hcm = in.nextDouble();

        double h = hcm / 100.0;
        double bmi = w / (h * h);

        String status;
        if (bmi <= 18.4) status = "Underweight";
        else if (bmi <= 24.9) status = "Normal";
        else if (bmi <= 39.9) status = "Overweight";
        else status = "Obese";

        System.out.printf("BMI: %.2f - %s\n", bmi, status);
        in.close();
    }
}
