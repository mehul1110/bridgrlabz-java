import java.util.Scanner;

/*
 * Program to calculate employee bonus based on years of service
 */
public class EmployeeBonusCalculator {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter salary: ");
        double salary = input.nextDouble();
        System.out.print("Enter years of service: ");
        int years = input.nextInt();

        double bonus = 0.0;
        
        // Calculate bonus if service is more than 5 years
        if (years > 5) {
            bonus = salary * 0.05;
        }
        
        System.out.println("The bonus amount is INR " + bonus);
        
        // Close Scanner
        input.close();
    }
}