import java.util.Scanner;

public class QuotientRemainder {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int q = number / divisor;
        int r = number % divisor;
        return new int[]{r, q};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter dividend: ");
        int n = in.nextInt();
        System.out.print("Enter divisor: ");
        int d = in.nextInt();
        int[] res = findRemainderAndQuotient(n, d);
        System.out.println("Quotient: " + res[1] + ", Remainder: " + res[0]);
        in.close();
    }
}
