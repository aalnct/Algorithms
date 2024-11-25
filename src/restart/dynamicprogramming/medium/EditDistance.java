package restart.dynamicprogramming.medium;

public class EditDistance {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        System.out.println(minDistance(word1,word2));
    }

    static int  minDistance (String word1, String word2) {
        // replace word1 with word2

        int m = word1.length();
        int n = word2.length();

        int [][] dp = new int[m+1][n+1];

        // if word2 is empty, remove all characters from word1
        for (int i=0; i <=m; i++) {
            dp[i][0] = i;
        }

        for (int j=0; j<=n; j++) {
            dp[0][j] = j; // if word1 is empty, insert all word2
        }

        for (int i=1; i <= m; i++) {
            for (int j=1; j<=n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] , Math.min(dp[i-1][j-1] ,  dp[i][j-1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
