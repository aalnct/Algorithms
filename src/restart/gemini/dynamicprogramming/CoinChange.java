package restart.gemini.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int [] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }

    static int coinChange (int [] coins, int amount) {
        int [] dp = new int[amount+1]; // because we also need to include dp[0]
        Arrays.fill(dp, amount+1);

        dp[0] = 0; // 0 coins needed to make 0 amount

        for (int i=1; i <= amount; i++) {
            for (int coin : coins) { // create combination for each coin
                if (i-coin >= 0) {
                    // memorize the dp formula for this problem
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1); // + 1 to include the coin
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
