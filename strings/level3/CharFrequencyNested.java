import java.util.Scanner;

/*
 * Program to count frequency of characters using nested loops
 */
public class CharFrequencyNested {

    public static String[] frequencyNested(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] freq = new int[n];
        
        // Loop through each character in the array
        for (int i = 0; i < n; i++) {
            // If character is marked as visited ('0'), skip it
            if (arr[i] == '0') continue;
             
            freq[i] = 1; // Initialize count
            
            // Inner loop to check against subsequent characters
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    freq[i]++; // Increment count for match
                    arr[j] = '0'; // Mark matched character as processed
                }
            }
        }
        
        java.util.List<String> out = new java.util.ArrayList<>();
        // Collect results for non-marked characters
        for (int i = 0; i < n; i++) {
            if (arr[i] != '0') {
                out.add(arr[i] + ":" + freq[i]);
            }
        }
        return out.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            
            // Calculate frequencies
            String[] res = frequencyNested(s);
            
            // Display results
            System.out.println("Char:Freq");
            for (String r : res) {
                System.out.println(r);
            }
        }
    }
}
