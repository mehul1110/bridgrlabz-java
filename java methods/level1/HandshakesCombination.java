import java.util.Scanner;

public class HandshakesCombination {
    public static long handshakes(long n) {
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        long n = in.nextLong();
        System.out.println("Maximum handshakes: " + handshakes(n));
        in.close();
    }
}
