package neetcode150.array;

import java.util.Arrays;

public class MinimumOperationUniValueGrid {

    public static void main(String[] args) {
        int [][] grid = {
                {1,5},
                {2,3}
        };
        int x = 1;

        System.out.println(minimumOperations(grid,x));
    }

    /**
     * this can be solved using following steps
     *
     * 1. first flatten the array to 1 D array
     * 2. check if the remainder of all elements is same  else it's not possible to form same number
     * 3. Sort the array
     * 4. Find the median value, and find each element distance from median
     *              dividing the distance by x to get the number of operations needed (since each operation
     *              exactly changes by x)
     *
     */

    static int minimumOperations (int [][] grid, int x) {
        int operations = 0;
        int m = grid.length;
        int n = grid[0].length;
        int index = 0;

        int [] flatten = new int[m * n];

        for (int i=0; i < m; i ++) {
            for (int j=0; j < n; j++) {
                flatten[index++] = grid[i][j];
            }
        }

        // check the remainder
        int remainder = flatten[0] % x;
        for (int value : flatten) {
            if (value % x != remainder) {
                return -1;
            }
        }

        // sort the array
        Arrays.sort(flatten);

        // median of array
        int median = flatten[flatten.length/2];

        // median will tell us the distance from each element to median value

        for (int val : flatten) {
            operations += Math.abs(val - median)/x;
        }

        return operations;
    }
}
