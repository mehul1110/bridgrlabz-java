import java.util.*;

/*
 * Program to generate random 4-digit numbers and analyze them
 * Computes average, minimum, and maximum values
 */
public class RandomStats {

    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        Random r = new Random();
        
        // Generate random 4-digit numbers (1000-9999)
        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + r.nextInt(9000);
        }
        return arr;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        if (numbers.length == 0) return new double[0];
        long sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        
        // Iterate through the array to find sum, min, and max
        for (int n : numbers) {
            sum += n;
            if (n < min) min = n;
            if (n > max) max = n;
        }
        
        // Calculate average
        double avg = (double) sum / numbers.length;
        
        // Return stats in an array
        return new double[] { avg, min, max };
    }

    public static void main(String[] args) {
        // Generate array of 5 random numbers
        int[] arr = generate4DigitRandomArray(5);
        
        // Print generated numbers
        System.out.println("Generated: " + Arrays.toString(arr));
        
        // Calculate statistics
        double[] stats = findAverageMinMax(arr);
        
        // Display statistics
        System.out.printf("Average=%.2f, Min=%.0f, Max=%.0f\n", stats[0], stats[1], stats[2]);
    }
}
