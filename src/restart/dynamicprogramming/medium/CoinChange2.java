package restart.dynamicprogramming.medium;

import java.util.Arrays;
import java.util.List;

public class CoinChange2 {

    public static void main(String[] args) {
        List<Long> coins = Arrays.asList(1L,2L,5L);
        int amount = 5;

        System.out.println(coinChange2(amount,coins));
    }

    static int coinChange2 (int amount, List<Long> coins) {
        int [] dp = new int[amount+1];
        dp[0] = 1; // exactly one way to make amount 0 _i.e. no coin

        for (long coin : coins) {
            for (int i = (int) coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - (int) coin];
            }
        }
        return dp[amount];
    }
}
