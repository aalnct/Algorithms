package neetcode150.binary.search;

import java.util.Arrays;

public class Search2DMatrix {

    public static void main(String[] args) {
        int [][] matrix = {
                {1,2,4,8},
                {10,11,12,13},
                {14,20,30,40}
        };
        int target = 15;

        System.out.println(searchMatrix(matrix,target));
    }

    static boolean searchMatrix (int [][] matrix, int target) {

        // flatten the matrix
        int index = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int [] flatten = new int [m * n];

        for (int i=0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                flatten[index++] = matrix[i][j];
            }
        }

        int left = 0;
        int right = flatten.length-1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (flatten[mid] == target) {
                 return true;
            } else if (flatten[mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        // System.out.println(Arrays.toString(flatten));

        return false;
    }
}
