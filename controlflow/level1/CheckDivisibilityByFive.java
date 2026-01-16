import java.util.Scanner;

public class CheckDivisibilityByFive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = input.nextInt();
        boolean divisible = number % 5 == 0;
        System.out.println("Is the number " + number + " divisible by 5? " + divisible);
        input.close();
    }
}