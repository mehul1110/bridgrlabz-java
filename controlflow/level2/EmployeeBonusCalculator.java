import java.util.Scanner;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter salary: ");
        double salary = input.nextDouble();
        System.out.print("Enter years of service: ");
        int years = input.nextInt();
        double bonus = 0.0;
        if (years > 5) bonus = salary * 0.05;
        System.out.println("The bonus amount is INR " + bonus);
        input.close();
    }
}