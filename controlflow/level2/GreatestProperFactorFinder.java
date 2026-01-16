import java.util.Scanner;

public class GreatestProperFactorFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        if (number <= 1) {
            System.out.println("No greatest factor besides itself for " + number);
        } else {
            int greatestFactor = 1;
            for (int i = number - 1; i >= 1; i--) {
                if (number % i == 0) {
                    greatestFactor = i;
                    break;
                }
            }
            System.out.println("The greatest factor besides itself is " + greatestFactor);
        }
        input.close();
    }
}