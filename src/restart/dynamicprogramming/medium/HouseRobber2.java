package restart.dynamicprogramming.medium;

public class HouseRobber2 {

    public static void main(String[] args) {
        int [] houses = {2,3,2};
        System.out.println(houseRobber(houses));
    }

    static int houseRobber(int [] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length < 2) {
            return nums[0];
        }

        int [] skipFirstHouse = new int[nums.length-1];
        int [] skipLastHouse = new int[nums.length-1];

        for (int i=0; i < nums.length-1; i++) {
            skipLastHouse[i] = nums[i];
            skipFirstHouse[i] = nums[i+1];
        }

        int skippingFirstHouse = robHouseHelper(skipFirstHouse);
        int skippingLastHouse = robHouseHelper(skipLastHouse);

        return Math.max(skippingFirstHouse,skippingLastHouse);
    }

    static int robHouseHelper (int [] nums) {
        int [] dp = new int[nums.length];

        if (nums.length < 2) {
            return nums[0];
        }

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);

        for (int i=2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[dp.length-1];
    }
}
