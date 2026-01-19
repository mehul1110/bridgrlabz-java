import java.util.Scanner;

/*
 * Program to print multiplication table for a number from 6 to 9
 */
public class MultiplicationTableSixToNine {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int number = input.nextInt();
        
        // Print table
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
        
        // Close Scanner
        input.close();
    }
}