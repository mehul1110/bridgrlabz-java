import java.util.Scanner;

public class SimpleInterest {
    public static double computeSimpleInterest(double principal, double rate, double time) {
        return principal * rate * time / 100.0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter principal: ");
        double p = in.nextDouble();
        System.out.print("Enter rate (percent): ");
        double r = in.nextDouble();
        System.out.print("Enter time (years): ");
        double t = in.nextDouble();

        double si = computeSimpleInterest(p, r, t);
        System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f and Time %.2f\n", si, p, r, t);
        in.close();
    }
}
