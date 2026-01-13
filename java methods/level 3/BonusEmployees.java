import java.util.Random;
import java.util.Scanner;

public class BonusEmployees {
    // Q11: compute bonus for 10 employees based on years of service
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        double[][] data = new double[n][3]; // salary, years, bonus
        Random r = new Random();
        double sumOld = 0, sumNew = 0, sumBonus = 0;
        for (int i = 0; i < n; i++) {
            double salary = 10000 + r.nextInt(90000); // 5-digit approx
            int years = r.nextInt(11); // 0..10
            double bonus = years > 5 ? salary * 0.05 : salary * 0.02;
            double newSalary = salary + bonus;
            data[i][0] = salary; data[i][1] = years; data[i][2] = bonus;
            sumOld += salary; sumNew += newSalary; sumBonus += bonus;
        }
        System.out.println("Idx\tSalary\tYears\tBonus\tNewSalary");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.0f\t%.0f\t%.2f\t%.2f\n", i+1, data[i][0], data[i][1], data[i][2], data[i][0]+data[i][2]);
        }
        System.out.printf("Total old salary = %.2f\n", sumOld);
        System.out.printf("Total new salary = %.2f\n", sumNew);
        System.out.printf("Total bonus = %.2f\n", sumBonus);
        sc.close();
    }
}
