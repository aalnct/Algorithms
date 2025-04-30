package restart.dynamicprogramming.leet_code_dp;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "ace";
        String text2 = "ac";

        System.out.println(longestCommonSubsequence(text1,text2));
        System.out.println(longestCommonSubSequenceDP(text1,text2));
    }

    static int longestCommonSubsequence (String text1, String text2) {
        return lcsRecursive(text1,text2,0,0);
    }

    static int lcsRecursive (String text1, String text2, int i, int j) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if (text1.charAt(i) ==  text2.charAt(j)) {
            return 1  + lcsRecursive(text1,text2, i+1, j+1);
        }

        int skipText2 = lcsRecursive(text1,text2, i, j+1);
        int skipText1 = lcsRecursive(text1,text2, i+1, j);

        return Math.max(skipText1,skipText2);
    }


    static int longestCommonSubSequenceDP (String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int [] [] dp = new int[m+1][n+1];

        // complete the dp matrix by comparing element to other in both string
        for (int i=1; i <= m; i++) {
            for (int j=1; j <=n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    // we either skip current or use current
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
