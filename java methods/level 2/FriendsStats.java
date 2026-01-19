import java.util.*;

/*
 * Program to analyze stats of friends (age and height)
 * Finds the youngest and tallest among a group
 */
public class FriendsStats {

    public static int youngestIndex(int[] ages) {
        int minIdx = 0;
        // Iterate through ages to find the index of the youngest
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[minIdx]) minIdx = i;
        }
        return minIdx;
    }

    public static int tallestIndex(double[] heights) {
        int maxIdx = 0;
        // Iterate through heights to find the index of the tallest
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[maxIdx]) maxIdx = i;
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        // Create Scanner
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        // Input loop for friends' data
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height (in cm) of " + names[i] + ": ");
            heights[i] = sc.nextDouble();
        }
        
        // Calculate statistics
        int y = youngestIndex(ages);
        int t = tallestIndex(heights);
        
        // Display statistics
        System.out.println("Youngest: " + names[y] + " (age=" + ages[y] + ")");
        System.out.println("Tallest: " + names[t] + " (height=" + heights[t] + " cm)");
    }
}
