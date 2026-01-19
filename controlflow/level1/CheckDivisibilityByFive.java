import java.util.Scanner;

/*
 * Program to check if a number is divisible by 5
 */
public class CheckDivisibilityByFive {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int number = input.nextInt();
        
        // Check divisibility
        boolean divisible = number % 5 == 0;
        
        // Display result
        System.out.println("Is the number " + number + " divisible by 5? " + divisible);
        
        // Close Scanner
        input.close();
    }
}