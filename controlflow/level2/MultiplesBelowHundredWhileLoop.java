import java.util.Scanner;

public class MultiplesBelowHundredWhileLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer less than 100: ");
        int number = input.nextInt();
        if (number < 1 || number >= 100) {
            System.out.println("Invalid input");
        } else {
            int counter = 100;
            System.out.println("Multiples of " + number + " below 100 are:");
            while (counter >= 1) {
                if (counter % number == 0) System.out.println(counter);
                counter--;
            }
        }
        input.close();
    }
}