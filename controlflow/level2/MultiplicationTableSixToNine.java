import java.util.Scanner;

/*
 * Program to display multiplication table for a number roughly from 6 to 9
 * (Note: The user input number is multiplied by 6, 7, 8, 9)
 */
public class MultiplicationTableSixToNine {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        // Re-using logic from level1 but ensuring correctness
        System.out.print("Enter number: ");
        int number = input.nextInt();
        
        // Print table entries
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
        
        // Close Scanner
        input.close();
    }
}