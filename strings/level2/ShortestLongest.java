import java.util.Scanner;

/*
 * Program to find shortest and longest words in a sentence
 */
public class ShortestLongest {

    public static String[] manualSplit(String s) {
        java.util.List<String> words = new java.util.ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        // Manual split logic: Iterate through characters to separate words by spaces
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                // If space found and buffer not empty, add buffer contents as a word
                if (sb.length() > 0) { 
                    words.add(sb.toString()); 
                    sb.setLength(0); // Clear buffer
                }
            } else {
                // Append character to current word buffer
                sb.append(c);
            }
        }
        // Add the last word if any exists after the loop
        if (sb.length() > 0) words.add(sb.toString());
        
        return words.toArray(new String[0]);
    }

    public static int manualLength(String s) { 
        int c = 0; 
        try { 
            // Loop until IndexOutOfBoundsException to count characters
            while (true) { s.charAt(c); c++; } 
        } catch (IndexOutOfBoundsException e) {
            // End of string reached
        } 
        return c; 
    }

    public static int[] shortestAndLongestIndexes(String[][] wordsAndLengths) {
        if (wordsAndLengths.length == 0) return new int[]{-1, -1};
        int minIdx = 0, maxIdx = 0;
        
        // Loop through words to find indices of the shortest and longest lengths
        for (int i = 1; i < wordsAndLengths.length; i++) {
            int len = Integer.parseInt(wordsAndLengths[i][1]);
            // Check if current word is shorter than minimum found so far
            if (len < Integer.parseInt(wordsAndLengths[minIdx][1])) minIdx = i;
            // Check if current word is longer than maximum found so far
            if (len > Integer.parseInt(wordsAndLengths[maxIdx][1])) maxIdx = i;
        }
        return new int[]{minIdx, maxIdx};
    }

    public static String[][] to2D(String[] words) {
        String[][] out = new String[words.length][2];
        // Create 2D array storing word and its manually calculated length
        for (int i = 0; i < words.length; i++) { 
            out[i][0] = words[i]; 
            out[i][1] = String.valueOf(manualLength(words[i])); 
        }
        return out;
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a line of text: ");
            String line = sc.nextLine();
            
            // Split sentence into words manually
            String[] words = manualSplit(line);
            
            // Prepare table with words and their lengths
            String[][] table = to2D(words);
            
            // Find shortest and longest words
            int[] idx = shortestAndLongestIndexes(table);
            
            if (idx[0] >= 0) {
                System.out.println("Shortest: " + table[idx[0]][0] + " (" + table[idx[0]][1] + ")");
                System.out.println("Longest : " + table[idx[1]][0] + " (" + table[idx[1]][1] + ")");
            } else {
                System.out.println("No words provided.");
            }
        }
    }
}
