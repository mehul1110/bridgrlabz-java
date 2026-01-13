import java.util.Scanner;

public class DigitsHarshadArmstrong {
    // Q3: digits tasks - count digits, sum of digits, sum squares, harshad check, frequency
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        System.out.println("Digit count = " + NumberCheckerUtils.countDigits(n));
        System.out.println("Digits array = java.util.Arrays.toString(" + java.util.Arrays.toString(NumberCheckerUtils.digitsArray(n)) + ")");
        System.out.println("Sum of digits = " + NumberCheckerUtils.sumDigits(n));
        System.out.println("Sum of squares of digits = " + NumberCheckerUtils.sumSquaresDigits(n));
        boolean harshad = (n % NumberCheckerUtils.sumDigits(n)) == 0;
        System.out.println("Is Harshad (N divisible by sum of digits)? " + harshad);

        int[] freq = digitFrequency(n);
        System.out.print("Digit frequencies: ");
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) System.out.print(i + ":" + freq[i] + " ");
        }
        System.out.println();
        sc.close();
    }

    public static int[] digitFrequency(int n) {
        n = Math.abs(n);
        int[] f = new int[10];
        if (n == 0) { f[0] = 1; return f; }
        while (n > 0) { f[n % 10]++; n /= 10; }
        return f;
    }
}
