import java.util.*;

public class StudentVoteChecker {
    public static boolean canStudentVote(int age) {
        if (age < 0) return false;
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        System.out.println("Enter ages for 10 students:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Student " + (i + 1) + " age: ");
            ages[i] = sc.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Student " + (i + 1) + " age=" + ages[i] + " can vote? " + canStudentVote(ages[i]));
        }
    }
}
