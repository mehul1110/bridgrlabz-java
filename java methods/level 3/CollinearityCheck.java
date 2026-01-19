import java.util.Scanner;

/*
 * Program to check if three points are collinear
 * It uses both slope formula and area of triangle method
 */
public class CollinearityCheck {

    public static boolean slopesCollinear(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Calculate slopes between points (1,2) and (2,3)
        double s1 = (y2 - y1) / (x2 - x1);
        double s2 = (y3 - y2) / (x3 - x2);
        
        // Check if slopes are approximately equal
        return Math.abs(s1 - s2) < 1e-9;
    }

    public static boolean areaCollinear(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Calculate area of triangle formed by the three points
        // Area = 0.5 * |x1(y2-y3) + x2(y3-y1) + x3(y1-y2)|
        double area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        
        // Check if area is effectively zero
        return Math.abs(area) < 1e-9;
    }

    public static void main(String[] args) {
        // Create Scanner
        Scanner sc = new Scanner(System.in);
        
        // Read coordinates for three points
        System.out.print("Enter x1 y1: "); double x1 = sc.nextDouble(); double y1 = sc.nextDouble();
        System.out.print("Enter x2 y2: "); double x2 = sc.nextDouble(); double y2 = sc.nextDouble();
        System.out.print("Enter x3 y3: "); double x3 = sc.nextDouble(); double y3 = sc.nextDouble();
        
        // Perform checks and display results
        System.out.println("Slopes collinear? " + slopesCollinear(x1, y1, x2, y2, x3, y3));
        System.out.println("Area collinear? " + areaCollinear(x1, y1, x2, y2, x3, y3));
        
        // Close Scanner
        sc.close();
    }
}
