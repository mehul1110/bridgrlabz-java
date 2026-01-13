import java.util.Scanner;

public class SpringSeasonMethod {
    public static boolean isSpring(int month, int day) {
        if (month == 3 && day >= 20) return true;
        if (month > 3 && month < 6) return true;
        if (month == 6 && day <= 20) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int m = in.nextInt();
        System.out.print("Enter day: ");
        int d = in.nextInt();
        System.out.println(isSpring(m, d) ? "Its a Spring Season" : "Not a Spring Season");
        in.close();
    }
}
