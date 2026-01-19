import java.util.Scanner;

/*
 * Program to display the number of possible handshakes
 * similar to HandshakesCombination but with a different class name
 */
public class HandshakesDisplay {

    public static long combinations(long n) {
        // Calculate combinations using the formula n * (n - 1) / 2
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        // Initialize the scanner for user input
        Scanner in = new Scanner(System.in);

        // Ask the user for the number of students
        System.out.print("Enter numberOfStudents: ");
        long n = in.nextLong();

        // Compute and print the number of possible handshakes
        System.out.println("Number of possible handshakes: " + combinations(n));

        // Close the input scanner
        in.close();
    }
}
