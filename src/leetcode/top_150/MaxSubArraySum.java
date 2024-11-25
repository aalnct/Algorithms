package leetcode.top_150;

public class MaxSubArraySum {

    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(findMaxSubArraySum(nums));
    }

    static int findMaxSubArraySum (int [] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i=1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
}
