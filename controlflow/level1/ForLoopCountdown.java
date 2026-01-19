import java.util.Scanner;

/*
 * Program to count down from a given value using a for loop
 */
public class ForLoopCountdown {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter countdown start value: ");
        int start = input.nextInt();
        
        // Countdown loop
        for (int i = start; i >= 1; i--) {
            System.out.println(i);
        }
        
        System.out.println("Liftoff!");
        
        // Close Scanner
        input.close();
    }
}