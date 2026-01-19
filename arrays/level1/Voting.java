import java.util.Scanner;

/*
 * Program to check voting eligibility for multiple students using an array
 */
public class Voting {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        int[] ages = new int[10];
        
        // Input ages
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            ages[i] = in.nextInt();
        }

        // Check eligibility
        for (int age : ages) {
            if (age < 0) System.out.println("Invalid age: " + age);
            else if (age >= 18) System.out.println("The student with the age " + age + " can vote.");
            else System.out.println("The student with the age " + age + " cannot vote.");
        }

        // Close Scanner
        in.close();
    }
}
