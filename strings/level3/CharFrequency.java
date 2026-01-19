import java.util.Scanner;

/*
 * Program to count frequency of characters in a string using a frequency array
 */
public class CharFrequency {

    public static String[][] frequency(String s) {
        // Create an array to store frequency for all ASCII characters
        int[] freq = new int[256];
        
        // Iterate through string to count each character's occurrence
        for (int i = 0; i < s.length(); i++) {
            freq[(int)s.charAt(i)]++;
        }
        
        java.util.List<String[]> list = new java.util.ArrayList<>();
        
        // Iterate through frequency array to collect characters that appeared
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                // Add character and its count to the list
                list.add(new String[]{String.valueOf((char)i), String.valueOf(freq[i])});
            }
        }
        return list.toArray(new String[0][]);
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            
            // Calculate frequencies
            String[][] table = frequency(s);
            
            // Display results
            System.out.printf("%-6s %s%n", "Char", "Freq");
            for (String[] r : table) {
                System.out.printf("%-6s %s%n", r[0], r[1]);
            }
        }
    }
}
