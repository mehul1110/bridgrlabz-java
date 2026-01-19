import java.util.Random;
import java.util.Scanner;

/*
 * Program to play a Number Guessing Game where the computer guesses the user's number
 */
public class NumberGuessingGame {

    public static int generateGuess(Random rnd, int low, int high) {
        // Generate random number in the current valid range [low, high]
        return low + rnd.nextInt(high - low + 1);
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            Random rnd = new Random();
            int low = 1, high = 100;
            System.out.println("Think of a number between 1 and 100. Respond with 'low', 'high', or 'correct'.");
            
            // Infinite loop for game rounds until guessed or inconsistency found
            while (true) {
                int guess = generateGuess(rnd, low, high);
                System.out.println("Is it " + guess + "?");
                String resp = sc.nextLine().trim().toLowerCase();
                
                // Process user response
                if (resp.equals("correct")) {
                    System.out.println("Guessed!");
                    break;
                } else if (resp.equals("low")) {
                    // Update lower bound if guess was too low
                    low = Math.max(low, guess + 1);
                } else if (resp.equals("high")) {
                    // Update upper bound if guess was too high
                    high = Math.min(high, guess - 1);
                }
                
                // Check if range has become invalid (user lied or made mistake)
                if (low > high) {
                    System.out.println("Inconsistent responses.");
                    break;
                }
            }
        }
    }
}
