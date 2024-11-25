package restart.array.advance.knapsack;

public class TargetSum {

    public static void main(String[] args) {
        int [] nums = {1,1,1,1,1};
        int target = 3;

        System.out.println(findTargetSum(nums,target));
    }

    private static int findTargetSum (int [] nums, int target) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((target + sum)%2 !=0 || (target > sum) ) {
            return 0; // solution not possible
        }

        int targetSum = (target + sum) /2;
        return countSubSet(nums, targetSum);
    }

    private static int countSubSet(int [] nums, int targetSum) {
        int [] dp = new int[targetSum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = targetSum; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }

        return dp[targetSum];
    }

}
