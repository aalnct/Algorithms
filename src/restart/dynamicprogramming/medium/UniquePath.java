package restart.dynamicprogramming.medium;

public class UniquePath {

    /**
     * we have to find a unique paths to travel from starting position
     * to end position
     */

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        System.out.println(uniquePath(m,n));
    }

    // lets say we have a grid of m * n where m and n is 3
    static int uniquePath (int m, int n) {
        // time complexity : O(m*n)
        // space complexity : O(N)

        // first row is always 1 for all blocks in grid
        // 1 1 1
        int [] dp = new int[n];

        for (int j=0; j < n; j++) {
            dp[j] = 1;
        }

        // i is row and j is col
        // once each col of that row is processed,
        // will move to next row
        for (int i=1; i < m; i++) {
            for (int j=1; j < n; j++) {
                dp[j] = dp[j] + dp[j-1]; // current col + previous processed column of that row, that will also be counted
            }
        }

        return dp[n-1]; // return the value of last index
    }
}
