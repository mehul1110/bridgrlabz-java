import java.util.Scanner;

/*
 * Program to find the youngest and tallest among friends
 * Uses arrays to store ages and heights
 */
public class YoungestTallest {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        String[] names = {"Amar","Akbar","Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        // Input loop
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for " + names[i] + ": ");
            ages[i] = in.nextInt();
            System.out.print("Enter height (cm) for " + names[i] + ": ");
            heights[i] = in.nextDouble();
        }

        int minAgeIdx = 0;
        // Find youngest
        for (int i = 1; i < 3; i++) if (ages[i] < ages[minAgeIdx]) minAgeIdx = i;
        
        int maxHeightIdx = 0;
        // Find tallest
        for (int i = 1; i < 3; i++) if (heights[i] > heights[maxHeightIdx]) maxHeightIdx = i;

        // Display results
        System.out.println("Youngest: " + names[minAgeIdx] + " (" + ages[minAgeIdx] + ")");
        System.out.println("Tallest: " + names[maxHeightIdx] + " (" + heights[maxHeightIdx] + " cm)");
        
        // Close Scanner
        in.close();
    }
}
