import java.util.Scanner;

/*
 * Program to determine voting eligibility of students with random ages using 2D array
 */
public class VotingAges {

    public static int[] randomAges(int n) {
        int[] a = new int[n];
        // Generate random ages between 10 and 99 for 'n' students
        for (int i = 0; i < n; i++) {
            a[i] = 10 + (int)(Math.random() * 90); 
        }
        return a;
    }

    public static String[][] ageVoteTable(int[] ages) {
        String[][] out = new String[ages.length][2];
        // Loop through each age to determine voting eligibility
        for (int i = 0; i < ages.length; i++) {
            out[i][0] = String.valueOf(ages[i]);
            
            // Check if age is 18 or greater
            boolean can = ages[i] >= 18;
            
            // Safety check for negative ages
            if (ages[i] < 0) can = false;
            
            out[i][1] = String.valueOf(can);
        }
        return out;
    }

    public static void display(String[][] table) {
        System.out.printf("%-8s %s%n", "Age", "CanVote");
        // Loop to display the results table
        for (String[] r : table) {
            System.out.printf("%-8s %s%n", r[0], r[1]);
        }
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Number of students: ");
            int n = sc.nextInt();
            
            // Generate ages and compute voting table
            int[] ages = randomAges(n);
            String[][] table = ageVoteTable(ages);
            
            // Display results
            display(table);
        }
    }
}
