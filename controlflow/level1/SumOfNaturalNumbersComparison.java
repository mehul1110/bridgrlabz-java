import java.util.Scanner;

/*
 * Program to compare sum of natural numbers using formula vs while loop
 */
public class SumOfNaturalNumbersComparison {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        int n = input.nextInt();
        
        // Check if n is valid
        if (n < 1) {
            System.out.println("The number " + n + " is not a natural number");
        } else {
            // Calculate using formula
            int formula = n * (n + 1) / 2;
            
            int sum = 0;
            int i = 1;
            
            // Calculate using while loop
            while (i <= n) {
                sum += i;
                i++;
            }
            
            // Compare results
            System.out.println("Formula result: " + formula + ", While loop result: " + sum);
        }
        
        // Close Scanner
        input.close();
    }
}