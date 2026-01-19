import java.util.Scanner;

/*
 * Program to check if a person is eligible to vote based on age
 */
public class VotingEligibilityChecker {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter age: ");
        int age = input.nextInt();
        
        // Check voting eligibility
        if (age >= 18) {
            System.out.println("The person's age is " + age + " and can vote.");
        } else {
            System.out.println("The person's age is " + age + " and cannot vote.");
        }
        
        // Close Scanner
        input.close();
    }
}