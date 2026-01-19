import java.util.Scanner;

/*
 * Program to find multiples of a number below 100 using a backwards while loop
 */
public class MultiplesBelowHundredWhileLoop {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer less than 100: ");
        int number = input.nextInt();
        
        // Validation
        if (number < 1 || number >= 100) {
            System.out.println("Invalid input");
        } else {
            int counter = 100;
            System.out.println("Multiples of " + number + " below 100 are:");
            // Loop backwards
            while (counter >= 1) {
                if (counter % number == 0) System.out.println(counter);
                counter--;
            }
        }
        
        // Close Scanner
        input.close();
    }
}