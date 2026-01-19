import java.util.*;

/*
 * Program to find roots of a quadratic equation
 * Solves ax^2 + bx + c = 0
 */
public class Quadratic {

    public static double[] findRoots(double a, double b, double c) {
        // If coefficient 'a' is 0, it's not a quadratic equation
        if (a == 0) return new double[0];
        
        // Calculate the discriminant (delta)
        double delta = b * b - 4 * a * c;
        
        // If delta is negative, roots are imaginary (not real)
        if (delta < 0) return new double[0];
        
        // If delta is zero, there is exactly one real root
        if (delta == 0) return new double[] { -b / (2 * a) };
        
        // If delta is positive, calculate two distinct real roots
        double sqrt = Math.sqrt(delta);
        double r1 = (-b + sqrt) / (2 * a);
        double r2 = (-b - sqrt) / (2 * a);
        
        // Return both roots
        return new double[] { r1, r2 };
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);
        
        // Prompt for coefficients
        System.out.print("Enter a b c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        
        // Find roots
        double[] roots = findRoots(a, b, c);
        
        // Display results based on number of roots found
        if (roots.length == 0) {
            System.out.println("No real roots or invalid quadratic.");
        } else if (roots.length == 1) {
            System.out.println("One root: " + roots[0]);
        } else {
            System.out.println("Roots: " + roots[0] + ", " + roots[1]);
        }
    }
}
