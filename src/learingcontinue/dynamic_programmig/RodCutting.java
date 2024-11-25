package learingcontinue.dynamic_programmig;

public class RodCutting {

    public static void main(String[] args) {
        int length =  5;
        int [] prices = {0, 2, 5, 9, 6, 10};
        System.out.println(maxProfit(length,prices));
    }

    static int maxProfit (int length, int [] prices) {
        int [] dp = new int[length+1];
        dp[0] = 0; // since there is no rod to cut initially

        for (int i=1; i <= length; i++) {
            int maxProfit = Integer.MIN_VALUE;

            for (int j = i; j <= i; j++) {
                maxProfit = Math.max(maxProfit, prices[j] + dp[i-j]);
            }

            dp[i] = maxProfit;
        }

        return dp[length];
    }
}
