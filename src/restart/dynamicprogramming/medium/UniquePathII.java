package restart.dynamicprogramming.medium;

public class UniquePathII {

    public static void main(String[] args) {
        int [][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        System.out.println(uniquePathII(obstacleGrid));
    }

    static int uniquePathII (int [][] obstaclePath) {
        // if there is obstacle at (0,0) or (m-1, n-1) then
        // we can never reach the destination

        int m = obstaclePath.length;
        int n = obstaclePath[0].length;

        int [] dp = new int [n];

        dp[0] = obstaclePath[0][0] == 0 ? 1 : 0;

        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if (obstaclePath[i][j] == 1) {
                    dp[j] = 0; // because if there is any obstacle , that path cannot be taken, so cannot count in total steps
                } else if ( j > 0) { // to make sure that we do not go out of bound
                    dp[j] = dp[j] + dp[j-1];
                }
            }
        }
        return dp[n-1];
    }
}
