import java.util.Scanner;

public class SignCheck {
    public static int signOf(int n) {
        if (n < 0) return -1;
        if (n > 0) return 1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter integer: ");
        int v = in.nextInt();
        System.out.println("Sign: " + signOf(v));
        in.close();
    }
}
