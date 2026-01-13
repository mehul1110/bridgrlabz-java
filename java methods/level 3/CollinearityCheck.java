import java.util.Scanner;

public class CollinearityCheck {
    // Q10: check collinearity using slopes and area
    public static boolean slopesCollinear(double x1,double y1,double x2,double y2,double x3,double y3) {
        double s1 = (y2 - y1) / (x2 - x1);
        double s2 = (y3 - y2) / (x3 - x2);
        return Math.abs(s1 - s2) < 1e-9;
    }

    public static boolean areaCollinear(double x1,double y1,double x2,double y2,double x3,double y3) {
        double area = x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2);
        return Math.abs(area) < 1e-9;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x1 y1: "); double x1 = sc.nextDouble(); double y1 = sc.nextDouble();
        System.out.print("Enter x2 y2: "); double x2 = sc.nextDouble(); double y2 = sc.nextDouble();
        System.out.print("Enter x3 y3: "); double x3 = sc.nextDouble(); double y3 = sc.nextDouble();
        System.out.println("Slopes collinear? " + slopesCollinear(x1,y1,x2,y2,x3,y3));
        System.out.println("Area collinear? " + areaCollinear(x1,y1,x2,y2,x3,y3));
        sc.close();
    }
}
