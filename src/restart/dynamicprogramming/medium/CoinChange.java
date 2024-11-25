package restart.dynamicprogramming.medium;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int [] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }

    static int coinChange (int [] coins, int amount) {
        int [] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);

        dp[0] = 0; // no coin needed to make amount 0
        if (amount < 1) {
            return 0;
        }

        // two loops
        for (int i=1; i <=amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
