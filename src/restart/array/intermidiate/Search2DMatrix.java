package restart.array.intermidiate;

public class Search2DMatrix {

    public static void main(String[] args) {
        int [][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;

        System.out.println(searchMatrix(matrix,target));
    }

    static boolean searchMatrix (int [][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Starting from top right corner
        int row = 0;
        int col = cols-1;

        // Should be within the boundary
        while (row < rows  && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--; // moving to left
            } else {
                row++; // moving to next row
            }
        }

        return true;
    }
}
