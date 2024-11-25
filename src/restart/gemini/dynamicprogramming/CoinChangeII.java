package restart.gemini.dynamicprogramming;

public class CoinChangeII {

    public static void main(String[] args) {
        int [] coins = {1,2,5};
        int amount = 5;
        System.out.println(coinChangeII(coins,amount));
    }

    // all the combination that can be made using the
    // given coins
    static int coinChangeII (int [] coins, int amount) {
        int [] dp = new int[amount+1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i-coin];
            }
        }
        return dp[amount];
    }

}
