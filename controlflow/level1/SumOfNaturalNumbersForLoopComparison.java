import java.util.Scanner;

public class SumOfNaturalNumbersForLoopComparison {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = input.nextInt();
        if (n < 1) {
            System.out.println("The number " + n + " is not a natural number");
        } else {
            int formula = n * (n + 1) / 2;
            int sum = 0;
            for (int i = 1; i <= n; i++) sum += i;
            System.out.println("Formula result: " + formula + ", For loop result: " + sum);
        }
        input.close();
    }
}