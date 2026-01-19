import java.util.Scanner;

/*
 * Program to store numbers in an array until a zero or negative number is entered
 */
public class StoreUntilZero {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        double[] arr = new double[10];
        double total = 0.0;
        int idx = 0;

        // Input loop
        while (true) {
            System.out.print("Enter a positive number (0 or negative to stop): ");
            double v = in.nextDouble();
            
            // Break conditions
            if (v <= 0) break;
            if (idx == 10) break;
            
            // Store value
            arr[idx++] = v;
        }

        // Display entered values and calculate sum
        System.out.println("Values entered:");
        for (int i = 0; i < idx; i++) {
            System.out.println(arr[i]);
            total += arr[i];
        }

        // Display total sum
        System.out.println("Sum: " + total);
        
        // Close Scanner
        in.close();
    }
}
