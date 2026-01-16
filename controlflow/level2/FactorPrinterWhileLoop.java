import java.util.Scanner;

public class FactorPrinterWhileLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        if (number < 1) {
            System.out.println("The number " + number + " is not a positive integer");
        } else {
            System.out.println("Factors of " + number + " are:");
            int i = 1;
            while (i < number) {
                if (number % i == 0) System.out.println(i);
                i++;
            }
        }
        input.close();
    }
}