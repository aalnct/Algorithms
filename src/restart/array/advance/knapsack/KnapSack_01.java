package restart.array.advance.knapsack;

public class KnapSack_01 {

    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int W = 7;
        System.out.println(" **** Maximum Value that can be placed in bag based on" +
                " the capacity given " + knapSack(weights,values,W) + " **** ");
    }

    static int knapSack (int [] weight, int [] values, int W) {
        // W is the total capacity
        int n = weight.length;
        int [][] dp = new int [n+1][W+1];

        for (int i = 1; i <=n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weight[i-1] <= w) {
                    // use the logic to set the value in chart
                    dp[i][w] = Math.max(
                            dp[i-1][w], dp[i-1][w-weight[i-1]] + values[i-1]
                    );
                }
                else {
                    // if this item cannot be included, inherit the value from previous item
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[n][W];
    }

}
