import java.util.*;

/*
 * Program to check if a student can vote based on age
 * Voting age is considered 18 and above
 */
public class StudentVoteChecker {

    public static boolean canStudentVote(int age) {
        // Age must be non-negative
        if (age < 0) return false;
        
        // Check if age is 18 or older
        return age >= 18;
    }

    public static void main(String[] args) {
        // Initialize Scanner for user input
        Scanner sc = new Scanner(System.in);
        
        // Array to store ages of 10 students
        int[] ages = new int[10];
        
        System.out.println("Enter ages for 10 students:");
        // Input loop
        for (int i = 0; i < 10; i++) {
            System.out.print("Student " + (i + 1) + " age: ");
            ages[i] = sc.nextInt();
        }
        
        // Check and display voting eligibility for each student
        for (int i = 0; i < 10; i++) {
            System.out.println("Student " + (i + 1) + " age=" + ages[i] + " can vote? " + canStudentVote(ages[i]));
        }
    }
}
