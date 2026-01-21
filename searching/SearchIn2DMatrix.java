package searching;

/**
 * Problem: Binary Search in a 2D matrix where rows are sorted and
 * first element of row > last element of previous row.
 */
public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        int target = 3;

        boolean found = searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + found);
    }

    /**
     * Searches a 2D matrix by treating it as a flattened 1D array.
     * 
     * @param matrix 2D sorted matrix
     * @param target Value to search
     * @return True if found, false otherwise
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Map 1D index back to 2D indices
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
