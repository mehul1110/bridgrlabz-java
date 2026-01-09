import java.util.Scanner;

public class LeapYearSingleIf {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = in.nextInt();

        if (year < 1582) {
            System.out.println("Year must be >= 1582 for Gregorian calendar checks.");
        } else {
            boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            System.out.println(year + (isLeap ? " is a Leap Year" : " is not a Leap Year"));
        }

        in.close();
    }
}
