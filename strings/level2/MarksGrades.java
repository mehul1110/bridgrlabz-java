import java.util.Scanner;

/*
 * Program to calculate grades of students using 2D arrays and random PCM marks
 */
public class MarksGrades {

    public static int[][] randomPCM(int n) {
        int[][] a = new int[n][3];
        // Generate random marks for Physics, Chemistry, and Math for 'n' students
        for (int i = 0; i < n; i++) {
            // Iterate for each subject (3 subjects)
            for (int j = 0; j < 3; j++) {
                // Generate a random score between 0 and 100
                a[i][j] = (int)(Math.random() * 101);
            }
        }
        return a;
    }

    public static String[][] totalsAndPercentages(int[][] pcm) {
        int n = pcm.length;
        String[][] out = new String[n][4];
        
        // Loop through each student to calculate their academic performance stats
        for (int i = 0; i < n; i++) {
            // Calculate total marks by summing scores of 3 subjects
            int total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            
            // Calculate Average marks, rounded to 2 decimal places
            double avg = Math.round((total / 3.0) * 100.0) / 100.0;
            
            // Calculate Percentage, rounded to 2 decimal places
            double pct = Math.round((total / 300.0 * 100.0) * 100.0) / 100.0;
            
            // Store results as strings in the output array
            out[i][0] = String.valueOf(total);
            out[i][1] = String.valueOf(avg);
            out[i][2] = String.valueOf(pct);
            out[i][3] = gradeFor(pct); // Determine grade based on percentage
        }
        return out;
    }

    public static String gradeFor(double pct) {
        // Determine Grade based on percentage brackets
        if (pct >= 80) return "A";
        if (pct >= 70) return "B";
        if (pct >= 60) return "C";
        if (pct >= 50) return "D";
        if (pct >= 40) return "E";
        // Default fail grade
        return "R";
    }

    public static void display(int[][] pcm, String[][] stats) {
        // Print table header
        System.out.printf("%-6s %-6s %-6s %-6s %-8s %-10s %s%n", "Phy", "Chem", "Math", "Total", "Average", "Percent", "Grade");
        
        // Loop through each student record to display marks and stats
        for (int i = 0; i < pcm.length; i++) {
            System.out.printf("%-6d %-6d %-6d %-6s %-8s %-10s %s%n",
                pcm[i][0], pcm[i][1], pcm[i][2], stats[i][0], stats[i][1], stats[i][2], stats[i][3]);
        }
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Number of students: ");
            int n = sc.nextInt();
            
            // Generate random marks
            int[][] pcm = randomPCM(n);
            
            // Calculate statistics (Total, Avg, %, Grade)
            String[][] stats = totalsAndPercentages(pcm);
            
            // Display final scorecard
            display(pcm, stats);
        }
    }
}
