import java.util.Scanner;

public class EuclideanLine {
    // Q9: Euclidean distance and line equation given two points
    public static double distance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1; double dy = y2 - y1; return Math.sqrt(dx*dx + dy*dy);
    }

    public static double[] lineEquation(double x1, double y1, double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        return new double[]{m, b};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x1 y1: "); double x1 = sc.nextDouble(); double y1 = sc.nextDouble();
        System.out.print("Enter x2 y2: "); double x2 = sc.nextDouble(); double y2 = sc.nextDouble();
        System.out.printf("Distance = %.4f\n", distance(x1,y1,x2,y2));
        if (x2 != x1) {
            double[] mb = lineEquation(x1,y1,x2,y2);
            System.out.printf("Line: y = %.4fx + %.4f\n", mb[0], mb[1]);
        } else {
            System.out.println("Line is vertical: x = " + x1);
        }
        sc.close();
    }
}
