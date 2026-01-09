import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = input.nextInt();
        if (number < 1) {
            System.out.println("The number " + number + " is not a natural number");
        } else {
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) System.out.println(i + " is even");
                else System.out.println(i + " is odd");
            }
        }
        input.close();
    }
}