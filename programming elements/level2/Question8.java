import java.util.Scanner;

public class Question8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a (double): ");
        double a = input.nextDouble();
        System.out.print("Enter b (double): ");
        double b = input.nextDouble();
        System.out.print("Enter c (double): ");
        double c = input.nextDouble();

        double op1 = a + b * c;
        double op2 = a * b + c;
        double op3 = c + a / b;
        double op4 = a % b + c;

        System.out.println("The results of Double Operations are " + op1 + ", " + op2 + ", " + op3 + ", " + op4);
        input.close();
    }
}