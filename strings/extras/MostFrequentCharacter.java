import java.util.Scanner;

/*
 * Program to find the most frequent character in a string
 */
public class MostFrequentCharacter {

    public static char mostFrequent(String s) {
        int[] freq = new int[256];
        
        // Loop to count character frequencies
        for (int i = 0; i < s.length(); i++) {
            freq[(int)s.charAt(i)]++;
        }
        
        int best = 0;
        // Loop to find the character index with the maximum frequency
        for (int i = 1; i < 256; i++) {
            if (freq[i] > freq[best]) {
                best = i;
            }
        }
        return (char)best;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            
            // Find and display most frequent character
            System.out.println("Most Frequent Character: '" + mostFrequent(s) + "'");
        }
    }
}
