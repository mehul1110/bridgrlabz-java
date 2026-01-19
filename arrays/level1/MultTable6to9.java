import java.util.Scanner;

/*
 * Program to display multiplication table for a number from 6 to 9
 * Uses an array to store results
 */
public class MultTable6to9 {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int num = in.nextInt();
        
        int[] res = new int[4];
        
        // Calculate and store results for 6 to 9
        for (int i = 6; i <= 9; i++) res[i - 6] = num * i;
        
        // Display results
        for (int i = 6; i <= 9; i++) System.out.println(num + " * " + i + " = " + res[i - 6]);
        
        // Close Scanner
        in.close();
    }
}
