import java.util.Scanner;

/*
 * Program to calculate bonus for employees based on years of service and salary
 * Uses arrays to store employee data and computes total metrics
 */
public class BonusEmployees {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        // Arrays for 10 employees
        double[] salary = new double[10];
        int[] years = new int[10];
        double[] bonus = new double[10];
        double totalBonus = 0, totalOld = 0, totalNew = 0;

        // Input loop
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            salary[i] = in.nextDouble();
            System.out.print("Enter years of service for employee " + (i + 1) + ": ");
            years[i] = in.nextInt();
        }

        // Calculation loop
        for (int i = 0; i < 10; i++) {
            // Apply bonus logic
            if (years[i] > 5) bonus[i] = salary[i] * 0.05;
            else bonus[i] = salary[i] * 0.02;
            
            // Accumulate totals
            totalBonus += bonus[i];
            totalOld += salary[i];
            totalNew += (salary[i] + bonus[i]);
        }

        // Display results table
        System.out.println("Employee | Salary | Years | Bonus | NewSalary");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d | %.2f | %d | %.2f | %.2f\n", i+1, salary[i], years[i], bonus[i], salary[i]+bonus[i]);
        }
        
        // Display summary totals
        System.out.printf("Total bonus: %.2f\nTotal old salary: %.2f\nTotal new salary: %.2f\n", totalBonus, totalOld, totalNew);
        
        // Close Scanner
        in.close();
    }
}
