import java.util.Scanner;

/*
 * Program to reverse a string
 */
public class ReverseString {

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        // Loop backwards from the end of the string to the beginning
        for (int i = s.length() - 1; i >= 0; i--) {
            // Append characters in reverse order
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String s = sc.nextLine();
            
            // Display reversed string
            System.out.println("Reversed: " + reverse(s));
        }
    }
}
