import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = in.nextInt();
        int[] table = new int[10];
        for (int i = 1; i <= 10; i++) table[i - 1] = num * i;
        for (int i = 1; i <= 10; i++) System.out.println(num + " * " + i + " = " + table[i - 1]);
        in.close();
    }
}
