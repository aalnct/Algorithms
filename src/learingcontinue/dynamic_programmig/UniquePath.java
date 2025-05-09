package learingcontinue.dynamic_programmig;

public class UniquePath {

    public static void main(String[] args) {
        System.out.println(uniquePath(3,4));
    }


    static int uniquePath (int m, int n ) {
        int [][] dp = new int[m][n];

        for (int i=0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j=0; j < n ; j++) {
            dp[0][j] = 1;
        }

        // calculate the number of unique paths for each cell
        for (int i =1; i < m ; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] =  dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
