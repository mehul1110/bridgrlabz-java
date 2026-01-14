import java.util.Scanner;

public class CountVowelsConsonants {
    public static int[] count(String s) {
        int vowels = 0, consonants = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                char lc = Character.toLowerCase(c);
                if (lc=='a'||lc=='e'||lc=='i'||lc=='o'||lc=='u') vowels++; else consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            int[] res = count(s);
            System.out.println("Vowels: " + res[0]);
            System.out.println("Consonants: " + res[1]);
        }
    }
}
