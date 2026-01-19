import java.util.Scanner;

/*
 * Program to calculate wind chill
 * Uses the National Weather Service Wind Chill formula
 */
public class WindChill {

    public static double calculateWindChill(double temperature, double windSpeed) {
        // Apply the standard Wind Chill formula using temperature and wind speed
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);

        // Get temperature in Fahrenheit
        System.out.print("Enter temperature (F): ");
        double temp = in.nextDouble();

        // Get wind speed in mph
        System.out.print("Enter wind speed (mph): ");
        double ws = in.nextDouble();

        // Calculate and display the Wind Chill index
        System.out.printf("Wind chill: %.2f\n", calculateWindChill(temp, ws));

        // Close Scanner
        in.close();
    }
}
