import java.util.Scanner;

/*
 * Program to compare three numbers and check if the first one is the smallest
 */
public class FindLargestOfThreeNumbers {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number1: ");
        int number1 = input.nextInt();
        System.out.print("Enter number2: ");
        int number2 = input.nextInt();
        System.out.print("Enter number3: ");
        int number3 = input.nextInt();

        // Check if first number is strictly smaller than the others
        boolean isSmallest = number1 < number2 && number1 < number3;
        
        // Display result
        System.out.println("Is the first number the smallest? " + isSmallest);
        
        // Close Scanner
        input.close();
    }
}