import java.util.*;
import java.util.ArrayList;

public class Quadratic {
    public static double[] findRoots(double a, double b, double c) {
        if (a == 0) return new double[0];
        double delta = b * b - 4 * a * c;
        if (delta < 0) return new double[0];
        if (delta == 0) return new double[] { -b / (2 * a) };
        double sqrt = Math.sqrt(delta);
        double r1 = (-b + sqrt) / (2 * a);
        double r2 = (-b - sqrt) / (2 * a);
        return new double[] { r1, r2 };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a b c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double[] roots = findRoots(a, b, c);
        if (roots.length == 0) {
            System.out.println("No real roots or invalid quadratic.");
        } else if (roots.length == 1) {
            System.out.println("One root: " + roots[0]);
        } else {
            System.out.println("Roots: " + roots[0] + ", " + roots[1]);
        }
    }
}
