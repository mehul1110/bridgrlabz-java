import java.util.Scanner;

/*
 * Program to find the greatest proper factor of a number using a while loop
 */
public class GreatestProperFactorWhileLoop {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        
        if (number <= 1) {
            System.out.println("No greatest factor besides itself for " + number);
        } else {
            int greatestFactor = 1;
            int counter = number - 1;
            // Loop backwards
            while (counter >= 1) {
                if (number % counter == 0) {
                    greatestFactor = counter;
                    break;
                }
                counter--;
            }
            System.out.println("The greatest factor besides itself is " + greatestFactor);
        }
        
        // Close Scanner
        input.close();
    }
}