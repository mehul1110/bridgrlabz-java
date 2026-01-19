import java.util.Scanner;

/*
 * Program to perform advanced number checks like palindrome and duck number
 * Utilizes NumberCheckerUtils for core logic
 */
public class NumberCheckAdvanced {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner sc = new Scanner(System.in);
        
        // Palindrome Check
        System.out.print("Enter number to reverse and check palindrome: ");
        int n = sc.nextInt();
        System.out.println("Reversed = " + NumberCheckerUtils.reverseNumber(n));
        System.out.println("Is palindrome? " + NumberCheckerUtils.isPalindrome(n));
        
        // Duck Number Check
        System.out.print("Enter another number to check duck property: ");
        int m = sc.nextInt();
        System.out.println("Is duck? " + NumberCheckerUtils.isDuck(m));
        
        // Close Scanner
        sc.close();
    }
}
