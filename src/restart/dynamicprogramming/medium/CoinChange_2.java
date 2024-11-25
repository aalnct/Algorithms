package restart.dynamicprogramming.medium;


import java.util.Arrays;

// this is same question where I have to find minimum number of coins needed to get the amount given
public class CoinChange_2 {

    public static void main(String[] args) {
        int [] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }

    static int coinChange (int [] coins, int amount) {
        int [] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);

        dp[0] = 0; // 0 coins are needed to make amount 0

        for (int i=1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >=0) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        return dp[amount];
    }
}
