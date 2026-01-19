import java.util.Scanner;

/*
 * Program to check if a number is positive, negative, or zero
 */
public class CheckNumberSign {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int number = input.nextInt();
        
        // Check sign of the number
        if (number > 0) {
            System.out.println("positive");
        } else if (number < 0) {
            System.out.println("negative");
        } else {
            System.out.println("zero");
        }
        
        // Close Scanner
        input.close();
    }
}