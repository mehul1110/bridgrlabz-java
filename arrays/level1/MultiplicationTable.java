import java.util.Scanner;

/*
 * Program to store and display multiplication table for a number
 */
public class MultiplicationTable {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int num = in.nextInt();
        
        int[] table = new int[10];
        
        // Compute table entries
        for (int i = 1; i <= 10; i++) table[i - 1] = num * i;
        
        // Display table
        for (int i = 1; i <= 10; i++) System.out.println(num + " * " + i + " = " + table[i - 1]);
        
        // Close Scanner
        in.close();
    }
}
