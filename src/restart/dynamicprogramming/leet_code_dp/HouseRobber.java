package restart.dynamicprogramming.leet_code_dp;

public class HouseRobber {

    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        System.out.println(houseRobber(nums));
    }

    static int houseRobber (int [] nums) {
        int n = nums.length;
        int [] dp = new int[n];

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return nums[0];
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for (int i= 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i] , dp[i-1]);
        }

        return dp[n-1];
    }
}
