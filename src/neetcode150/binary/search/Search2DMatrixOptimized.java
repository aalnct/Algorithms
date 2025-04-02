package neetcode150.binary.search;

public class Search2DMatrixOptimized {

    public static void main(String[] args) {
        int [][] matrix = {
                {1,2,4,8},
                {10,11,12,13},
                {14,20,30,40}
        };
        int target = 10;

        System.out.println(search2DMatrix(matrix,target));
    }

    static boolean search2DMatrix (int [][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        // this time we will not flatten the matrix, instead we will
        // map the index of 1D array to element of 2D array

        while (left <= right) {
            int mid = left + (right - left)/2;

            int midValue = matrix[mid/cols][mid%cols];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid +1;
            } else {
                right = mid -1;
            }
        }
        return false;
    }
}
