import java.util.Scanner;

/*
 * Program to compare sum of natural numbers using formula vs for loop
 */
public class SumOfNaturalNumbersForLoopComparison {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        int n = input.nextInt();
        
        // Check validity
        if (n < 1) {
            System.out.println("The number " + n + " is not a natural number");
        } else {
            // Calculate using formula
            int formula = n * (n + 1) / 2;
            
            int sum = 0;
            // Calculate using for loop
            for (int i = 1; i <= n; i++) sum += i;
            
            // Compare results
            System.out.println("Formula result: " + formula + ", For loop result: " + sum);
        }
        
        // Close Scanner
        input.close();
    }
}