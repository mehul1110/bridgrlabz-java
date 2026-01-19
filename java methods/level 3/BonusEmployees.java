import java.util.Random;
import java.util.Scanner;

/*
 * Program to calculate bonus for employees based on years of service
 * It simulates data for 10 employees
 */
public class BonusEmployees {

    public static void main(String[] args) {
        // Initialize Scanner for input
        Scanner sc = new Scanner(System.in);
        
        int n = 10;
        // 2D array to store salary, years of service, and bonus calculation
        double[][] data = new double[n][3]; // salary, years, bonus
        
        Random r = new Random();
        double sumOld = 0, sumNew = 0, sumBonus = 0;
        
        // Loop to generate data for each employee
        for (int i = 0; i < n; i++) {
            double salary = 10000 + r.nextInt(90000); // Generate 5-digit random salary
            int years = r.nextInt(11); // Generate years of service 0..10
            
            // Calculate bonus: 5% if service > 5 years, else 2%
            double bonus = years > 5 ? salary * 0.05 : salary * 0.02;
            
            double newSalary = salary + bonus;
            
            // Store data
            data[i][0] = salary;
            data[i][1] = years;
            data[i][2] = bonus;
            
            // Updates sums
            sumOld += salary;
            sumNew += newSalary;
            sumBonus += bonus;
        }
        
        // Display table header
        System.out.println("Idx\tSalary\tYears\tBonus\tNewSalary");
        
        // Display employee data
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.0f\t%.0f\t%.2f\t%.2f\n", i+1, data[i][0], data[i][1], data[i][2], data[i][0]+data[i][2]);
        }
        
        // Display totals
        System.out.printf("Total old salary = %.2f\n", sumOld);
        System.out.printf("Total new salary = %.2f\n", sumNew);
        System.out.printf("Total bonus = %.2f\n", sumBonus);
        
        // Close Scanner
        sc.close();
    }
}
