package restart.array.intermidiate;

public class MaximumSubArraySum {

    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArraySum(nums));
    }

    static int maxSubArraySum (int [] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int maxGlobalSum = nums[0];

        for (int i=1; i < nums.length; i++) {
            maxSum = Math.max(nums[i], maxSum + nums[i]);
            if (maxSum > maxGlobalSum) {
                maxGlobalSum = maxSum;
            }
        }
        return maxGlobalSum;
    }
}