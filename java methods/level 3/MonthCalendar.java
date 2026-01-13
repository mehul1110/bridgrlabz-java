import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MonthCalendar {
    // Q8: display calendar for a given month and year
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        Calendar cal = new GregorianCalendar(year, month - 1, 1);
        int firstDay = cal.get(Calendar.DAY_OF_WEEK); // 1=Sun
        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.printf("%s %d\n", cal.getDisplayName(Calendar.MONTH, Calendar.LONG, java.util.Locale.getDefault()), year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int indent = firstDay - 1;
        for (int i = 0; i < indent; i++) System.out.print("    ");
        for (int d = 1; d <= days; d++) {
            System.out.printf("%3d ", d);
            if ((d + indent) % 7 == 0) System.out.println();
        }
        System.out.println();
        sc.close();
    }
}
