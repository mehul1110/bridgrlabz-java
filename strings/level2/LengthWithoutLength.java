import java.util.Scanner;

public class LengthWithoutLength {
    public static int manualLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // end reached
        }
        return count;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter text (no spaces): ");
            String input = sc.next();
            System.out.println("Manual length: " + manualLength(input));
            System.out.println("Built-in length: " + input.length());
        }
    }
}
