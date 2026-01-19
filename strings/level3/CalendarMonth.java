import java.util.Scanner;

/*
 * Program to display a monthly calendar for a given month and year
 */
public class CalendarMonth {

    public static String monthName(int m) {
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        return months[m-1];
    }

    public static boolean isLeap(int y) {
        // Check leap year condition: divisible by 4 but not 100, unless divisible by 400
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    public static int daysInMonth(int m, int y) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        // Check for leap year only for February updates
        if (m == 2 && isLeap(y)) return 29;
        return days[m-1];
    }

    // Formula to calculate day of week for the 1st day of the month
    // Returns 0 for Sunday, 1 for Monday, etc.
    public static int firstDay(int m, int y) {
        int d = 1;
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31*m0)/12) % 7;
        return d0;
    }

    public static void display(int m, int y) {
        System.out.println("    " + monthName(m) + " " + y);
        System.out.println("Su Mo Tu We Th Fr Sa");
        
        int first = firstDay(m,y);
        int days = daysInMonth(m,y);
        
        // Loop to print leading spaces for the first week
        for (int i = 0; i < first; i++) {
            System.out.print("   ");
        }
        
        // Loop to print each day of the month
        for (int d = 1; d <= days; d++) {
            System.out.printf("%2d ", d);
            // Check if we reached the end of the week (Saturday) to start a new line
            if ((first + d) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter month (1-12): ");
            int m = sc.nextInt();
            System.out.print("Enter year: ");
            int y = sc.nextInt();
            
            // Display valid calendar
            display(m,y);
        }
    }
}
