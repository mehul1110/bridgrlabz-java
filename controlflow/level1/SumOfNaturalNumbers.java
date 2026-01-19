import java.util.Scanner;

/*
 * Program to calculate the sum of first N natural numbers using a formula
 */
public class SumOfNaturalNumbers {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int number = input.nextInt();
        
        // Check if number is natural
        if (number >= 1) {
            // Calculate sum using formula n*(n+1)/2
            int sum = number * (number + 1) / 2;
            System.out.println("The sum of " + number + " natural numbers is " + sum);
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
        
        // Close Scanner
        input.close();
    }
}