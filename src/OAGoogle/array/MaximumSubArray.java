package OAGoogle.array;

/**
 *  Kadane's algorithm
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArraySum(nums));
    }

    static int maxSubArraySum (int [] nums) {
        int currentSum  = nums[0];
        int maxSum = nums[0];

        for (int i=1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
