package restart.array.advance.knapsack;

public class SubSetSum {

    public static void main(String[] args) {
        int [] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }

    private static boolean canPartition(int [] nums) {

        int totalSum = 0;
        for (int num : nums) {
            totalSum +=num;
        }

        if (totalSum % 2 != 0) {
            return false; // for odd sum, it is always false
        }

        int target = totalSum/2;

        boolean [] dp = new boolean[target+1];

        dp[0] = true;

        for (int num : nums) {
            for (int j=target; j>= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

}
