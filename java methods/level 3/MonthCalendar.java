import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * Program to display the calendar for a given month and year
 * Uses Java's Calendar class
 */
public class MonthCalendar {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        
        // Create Calendar instance for the 1st day of the given month and year
        // Note: Month is 0-indexed in Calendar class, so subtract 1
        Calendar cal = new GregorianCalendar(year, month - 1, 1);
        
        // Get day of week for the 1st (1=Sun, 2=Mon, ...)
        int firstDay = cal.get(Calendar.DAY_OF_WEEK);
        
        // Get maximum days in the month
        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        // Display Month and Year
        System.out.printf("%s %d\n", cal.getDisplayName(Calendar.MONTH, Calendar.LONG, java.util.Locale.getDefault()), year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        
        // Calculate initial indentation
        int indent = firstDay - 1;
        
        // Print leading spaces for the first week
        for (int i = 0; i < indent; i++) System.out.print("    ");
        
        // Print days of the month
        for (int d = 1; d <= days; d++) {
            System.out.printf("%3d ", d);
            // Move to next line after Saturday
            if ((d + indent) % 7 == 0) System.out.println();
        }
        System.out.println();
        
        // Close Scanner
        sc.close();
    }
}
