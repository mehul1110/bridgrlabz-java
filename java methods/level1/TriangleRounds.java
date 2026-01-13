import java.util.Scanner;

public class TriangleRounds {
    public static double roundsForDistance(double side1, double side2, double side3, double distanceMeters) {
        double perimeter = side1 + side2 + side3;
        if (perimeter <= 0) return 0;
        return distanceMeters / perimeter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter side1 (m): ");
        double s1 = in.nextDouble();
        System.out.print("Enter side2 (m): ");
        double s2 = in.nextDouble();
        System.out.print("Enter side3 (m): ");
        double s3 = in.nextDouble();

        double rounds = roundsForDistance(s1, s2, s3, 5000.0);
        System.out.printf("Rounds needed to complete 5km: %.2f\n", rounds);
        in.close();
    }
}
