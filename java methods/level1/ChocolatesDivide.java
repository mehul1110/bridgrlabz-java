import java.util.Scanner;

public class ChocolatesDivide {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int q = number / divisor;
        int r = number % divisor;
        return new int[]{q, r};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter numberOfChocolates: ");
        int chocolates = in.nextInt();
        System.out.print("Enter numberOfChildren: ");
        int children = in.nextInt();
        if (children <= 0) {
            System.out.println("Invalid number of children");
            in.close();
            return;
        }
        int[] res = findRemainderAndQuotient(chocolates, children);
        System.out.println("Each child gets: " + res[0] + ", Remaining: " + res[1]);
        in.close();
    }
}
