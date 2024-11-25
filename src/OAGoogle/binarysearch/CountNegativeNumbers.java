package OAGoogle.binarysearch;

public class CountNegativeNumbers {

    public static void main(String[] args) {
        int [][] grid = {
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        };

        System.out.println(countNegative(grid));
    }

    static int countNegative (int [][] nums) {
        int rows = nums.length;
        int cols = nums[0].length;

        int count = 0; // to count  number of negative integers
        int row = rows -1; // we will start from bottom left and will reach top right
        int col = 0; // start from the first column

        while (row >= 0 && col < cols) {
            if (nums[row][col] < 0) {
                // if current element is negative move upwards in the current column
                count += (cols-col);
                row--;
            } else {
                col++; // move to next column
            }
        }
        return count;
    }
}
