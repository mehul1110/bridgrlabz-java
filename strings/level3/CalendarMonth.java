import java.util.Scanner;

public class CalendarMonth {
    public static String monthName(int m) {
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        return months[m-1];
    }

    public static boolean isLeap(int y) {
        return (y%4==0 && y%100!=0) || (y%400==0);
    }

    public static int daysInMonth(int m, int y) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (m==2 && isLeap(y)) return 29;
        return days[m-1];
    }

    // d0 formula expects day d (1) to get first day of month
    public static int firstDay(int m, int y) {
        int d = 1;
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31*m0)/12) % 7;
        return d0; // 0=Sunday
    }

    public static void display(int m, int y) {
        System.out.println("    " + monthName(m) + " " + y);
        System.out.println("Su Mo Tu We Th Fr Sa");
        int first = firstDay(m,y);
        int days = daysInMonth(m,y);
        for (int i = 0; i < first; i++) System.out.print("   ");
        for (int d = 1; d <= days; d++) {
            System.out.printf("%2d ", d);
            if ((first + d) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter month (1-12): ");
            int m = sc.nextInt();
            System.out.print("Enter year: ");
            int y = sc.nextInt();
            display(m,y);
        }
    }
}
