import java.util.Scanner;

/*
 * Program to count down from a given value using a while loop
 */
public class CountdownTimer {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter countdown start value: ");
        int counter = input.nextInt();
        
        // Countdown loop
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
        
        System.out.println("Liftoff!");
        
        // Close Scanner
        input.close();
    }
}