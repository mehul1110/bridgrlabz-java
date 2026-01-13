import java.util.*;

public class LeapYearChecker {
    public static boolean isLeapYear(int year) {
        if (year < 1582) return false;
        boolean a = (year % 4 == 0) && (year % 100 != 0);
        boolean b = (year % 400 == 0);
        return a || b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year (>=1582): ");
        int y = sc.nextInt();
        if (y < 1582) {
            System.out.println("Year must be >= 1582 for Gregorian calendar.");
            return;
        }
        System.out.println(y + (isLeapYear(y) ? " is a Leap Year" : " is not a Leap Year"));
    }
}
