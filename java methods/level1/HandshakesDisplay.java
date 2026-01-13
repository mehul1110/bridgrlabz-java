import java.util.Scanner;

public class HandshakesDisplay {
    public static long combinations(long n) {
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter numberOfStudents: ");
        long n = in.nextLong();
        System.out.println("Number of possible handshakes: " + combinations(n));
        in.close();
    }
}
