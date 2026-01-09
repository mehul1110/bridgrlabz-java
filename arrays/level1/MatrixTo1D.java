import java.util.Scanner;
import java.util.Arrays;

public class MatrixTo1D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int r = in.nextInt();
        System.out.print("Enter columns: ");
        int c = in.nextInt();
        int[][] mat = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                mat[i][j] = in.nextInt();
            }
        }

        int[] arr = new int[r * c];
        int idx = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[idx++] = mat[i][j];
            }
        }

        System.out.println("1D array: " + Arrays.toString(arr));
        in.close();
    }
}
