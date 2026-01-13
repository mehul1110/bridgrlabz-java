import java.util.Scanner;
import java.util.Arrays;

public class TrigFunctions {
    public static double[] calculateTrigonometricFunctions(double angleDegrees) {
        double rad = Math.toRadians(angleDegrees);
        double sin = Math.sin(rad);
        double cos = Math.cos(rad);
        double tan = Math.tan(rad);
        return new double[]{sin, cos, tan};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double a = in.nextDouble();
        double[] res = calculateTrigonometricFunctions(a);
        System.out.printf("sin=%.4f cos=%.4f tan=%.4f\n", res[0], res[1], res[2]);
        in.close();
    }
}
