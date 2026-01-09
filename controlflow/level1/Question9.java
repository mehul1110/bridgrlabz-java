import java.util.Scanner;

public class Question9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter countdown start value: ");
        int start = input.nextInt();
        for (int i = start; i >= 1; i--) {
            System.out.println(i);
        }
        System.out.println("Liftoff!");
        input.close();
    }
}