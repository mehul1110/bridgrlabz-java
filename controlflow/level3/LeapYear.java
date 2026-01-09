import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = in.nextInt();

        if (year < 1582) {
            System.out.println("Year must be >= 1582 for Gregorian calendar checks.");
        } else {
            boolean isLeap = false;
            if (year % 4 == 0) {
                if (year % 100 != 0) isLeap = true;
                else if (year % 400 == 0) isLeap = true;
            }
            if (isLeap) System.out.println(year + " is a Leap Year");
            else System.out.println(year + " is not a Leap Year");
        }

        in.close();
    }
}
