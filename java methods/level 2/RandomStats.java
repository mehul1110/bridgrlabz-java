import java.util.*;

public class RandomStats {
    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        Random r = new Random();
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
        for (int n : numbers) {
            sum += n;
            if (n < min) min = n;
            if (n > max) max = n;
        }
        double avg = (double) sum / numbers.length;
        return new double[] { avg, min, max };
    }

    public static void main(String[] args) {
        int[] arr = generate4DigitRandomArray(5);
        System.out.println("Generated: " + Arrays.toString(arr));
        double[] stats = findAverageMinMax(arr);
        System.out.printf("Average=%.2f, Min=%.0f, Max=%.0f\n", stats[0], stats[1], stats[2]);
    }
}
