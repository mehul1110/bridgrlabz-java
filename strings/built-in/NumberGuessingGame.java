import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static int generateGuess(Random rnd, int low, int high) {
        return low + rnd.nextInt(high - low + 1);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Random rnd = new Random();
            int low = 1, high = 100;
            System.out.println("Think of a number between 1 and 100. Respond with 'low', 'high', or 'correct'.");
            while (true) {
                int guess = generateGuess(rnd, low, high);
                System.out.println("Is it " + guess + "?");
                String resp = sc.nextLine().trim().toLowerCase();
                if (resp.equals("correct")) { System.out.println("Guessed!"); break; }
                else if (resp.equals("low")) low = Math.max(low, guess+1);
                else if (resp.equals("high")) high = Math.min(high, guess-1);
                if (low > high) { System.out.println("Inconsistent responses."); break; }
            }
        }
    }
}
