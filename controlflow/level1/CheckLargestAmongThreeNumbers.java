import java.util.Scanner;

/*
 * Program to check which of the three numbers is the largest
 */
public class CheckLargestAmongThreeNumbers {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number1: ");
        int number1 = input.nextInt();
        System.out.print("Enter number2: ");
        int number2 = input.nextInt();
        System.out.print("Enter number3: ");
        int number3 = input.nextInt();

        // Check if each number is the largest
        boolean firstLargest = number1 > number2 && number1 > number3;
        boolean secondLargest = number2 > number1 && number2 > number3;
        boolean thirdLargest = number3 > number1 && number3 > number2;

        // Display results
        System.out.println("Is the first number the largest? " + firstLargest);
        System.out.println("Is the second number the largest? " + secondLargest);
        System.out.println("Is the third number the largest? " + thirdLargest);
        
        // Close Scanner
        input.close();
    }
}