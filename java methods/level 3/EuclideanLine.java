import java.util.Scanner;

/*
 * Program to calculate Euclidean distance and find line equation between two points
 * Calculates distance and line coefficients (slope and intercept)
 */
public class EuclideanLine {

    public static double distance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        // Distance formula: sqrt(dx^2 + dy^2)
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static double[] lineEquation(double x1, double y1, double x2, double y2) {
        // Calculate slope (m)
        double m = (y2 - y1) / (x2 - x1);
        
        // Calculate y-intercept (b) using y = mx + b => b = y - mx
        double b = y1 - m * x1;
        
        return new double[]{m, b};
    }

    public static void main(String[] args) {
        // Initialize Scanner for input
        Scanner sc = new Scanner(System.in);
        
        // Read coordinates
        System.out.print("Enter x1 y1: "); double x1 = sc.nextDouble(); double y1 = sc.nextDouble();
        System.out.print("Enter x2 y2: "); double x2 = sc.nextDouble(); double y2 = sc.nextDouble();
        
        // Calculate and display distance
        System.out.printf("Distance = %.4f\n", distance(x1, y1, x2, y2));
        
        // Calculate line equation if not a vertical line
        if (x2 != x1) {
            double[] mb = lineEquation(x1, y1, x2, y2);
            System.out.printf("Line: y = %.4fx + %.4f\n", mb[0], mb[1]);
        } else {
            System.out.println("Line is vertical: x = " + x1);
        }
        
        // Close Scanner
        sc.close();
    }
}
