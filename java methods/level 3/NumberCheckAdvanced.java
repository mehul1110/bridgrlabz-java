import java.util.Scanner;

public class NumberCheckAdvanced {
    // Q4: reverse, compare arrays, palindrome, duck checks using NumberCheckerUtils
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to reverse and check palindrome: ");
        int n = sc.nextInt();
        System.out.println("Reversed = " + NumberCheckerUtils.reverseNumber(n));
        System.out.println("Is palindrome? " + NumberCheckerUtils.isPalindrome(n));
        System.out.print("Enter another number to check duck property: ");
        int m = sc.nextInt();
        System.out.println("Is duck? " + NumberCheckerUtils.isDuck(m));
        sc.close();
    }
}
