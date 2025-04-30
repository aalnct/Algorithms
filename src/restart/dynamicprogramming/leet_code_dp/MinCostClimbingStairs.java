package restart.dynamicprogramming.leet_code_dp;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int [] costs = {10,15,20};
        System.out.println(minCostClimbingStairs(costs));
    }

    static int minCostClimbingStairs (int [] costs) {

        int n = costs.length;
        int [] dp = new int[n+1];

        dp[n] = 0; // cost of last steps
        dp[n-1] = costs[n-1]; // cost of second last step

        for (int i = n-2; i >=0; i--) {
            dp[i] = costs[i] + Math.min(dp[i+1], dp[i+2]);
        }

        return Math.min(dp[0],dp[1]);
    }
}
