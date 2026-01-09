import java.util.Scanner;

public class StoreUntilZero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] arr = new double[10];
        double total = 0.0;
        int idx = 0;

        while (true) {
            System.out.print("Enter a positive number (0 or negative to stop): ");
            double v = in.nextDouble();
            if (v <= 0) break;
            if (idx == 10) break;
            arr[idx++] = v;
        }

        System.out.println("Values entered:");
        for (int i = 0; i < idx; i++) {
            System.out.println(arr[i]);
            total += arr[i];
        }

        System.out.println("Sum: " + total);
        in.close();
    }
}
