package restart.dynamicprogramming.leet_code_dp;

public class MaximalSquare {

    public static void main(String[] args) {
        char [][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        };

        System.out.println(maximalSquare(matrix));
    }

    static int maximalSquare (char [][] matrix) {
        // there are two scenarios
            // either current grid contains 1
            // or contains 0

        // if it contains 1, then we have to take min of left, upper, left-upper
        // to consider it as matrix else if any of this is 0, then we will do 0 + 1 so 1 only for the time being

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSideLength = 0;

        int [][] dp = new int [rows][cols];

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i== 0 || j == 0) {
                        // base case
                        dp[i][j] = 1; // because for row or column value of dp is 1
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }

                    maxSideLength = Math.max(maxSideLength, dp[i][j]);

                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxSideLength * maxSideLength; // calculating area
    }
}
