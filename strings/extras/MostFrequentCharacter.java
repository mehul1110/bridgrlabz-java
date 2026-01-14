import java.util.Scanner;

public class MostFrequentCharacter {
    public static char mostFrequent(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) freq[(int)s.charAt(i)]++;
        int best = 0;
        for (int i = 1; i < 256; i++) if (freq[i] > freq[best]) best = i;
        return (char)best;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            System.out.println("Most Frequent Character: '" + mostFrequent(s) + "'");
        }
    }
}
