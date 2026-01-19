import java.util.Scanner;

/*
 * Program to calculate the maximum number of handshakes possible among N students
 * using the mathematical combination formula n * (n - 1) / 2
 */
public class HandshakesCombination {

    public static long handshakes(long n) {
        // Apply the combination formula nC2 to calculate handshakes
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        // Create a Scanner object for reading input
        Scanner in = new Scanner(System.in);

        // Prompt the user to enter the number of students
        System.out.print("Enter number of students: ");
        long n = in.nextLong();

        // Calculate and display the maximum number of handshakes
        System.out.println("Maximum handshakes: " + handshakes(n));

        // Close the scanner
        in.close();
    }
}
