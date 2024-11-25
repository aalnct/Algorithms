package leetcode.top_150;

public class Search2DMatrix {

    public static void main(String[] args) {
        int [][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };

        int target = 3;

        System.out.println(search2DMatrix(matrix,target));
    }

    private static boolean search2DMatrix (int [][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols-1; // start from top right corner

        while (row < rows && col >= 0) {
            int current = matrix[row][col];

            if (current == target) {
                return true;
            } else if (current > target) {
                col--; // move left
            } else {
                row++; // move down
            }
        }
        return false;
    }
}
