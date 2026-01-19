import java.util.Scanner;
import java.util.Arrays;

/*
 * Program to convert a 2D matrix into a 1D array
 */
public class MatrixTo1D {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter rows: ");
        int r = in.nextInt();
        System.out.print("Enter columns: ");
        int c = in.nextInt();
        
        // Create matrix
        int[][] mat = new int[r][c];
        
        // Read matrix elements
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                mat[i][j] = in.nextInt();
            }
        }

        // Create 1D array
        int[] arr = new int[r * c];
        int idx = 0;
        
        // Copy elements from matrix to 1D array
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[idx++] = mat[i][j];
            }
        }

        // Display the 1D array
        System.out.println("1D array: " + Arrays.toString(arr));
        
        // Close Scanner
        in.close();
    }
}
