import java.util.Scanner;

public class MultTable6to9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = in.nextInt();
        int[] res = new int[4];
        for (int i = 6; i <= 9; i++) res[i - 6] = num * i;
        for (int i = 6; i <= 9; i++) System.out.println(num + " * " + i + " = " + res[i - 6]);
        in.close();
    }
}
