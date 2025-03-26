package restart.array.intermidiate;

public class MaximumSubArraySum2 {
    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maximumSubArraySum(nums));
    }

    static int maximumSubArraySum (int [] nums) {
        // have two variables
        // one to store the value of very first element
        // to store the max sum with each iteration

        int maxSum = nums[0];
        int  maxGlobal = nums [0];

        for (int i=1; i < nums.length; i++) {
            // checking if current number encountered is greater than the
            // total sum found so far ...
            maxSum = Math.max(nums[i], nums[i] + maxSum);
            if (maxSum > maxGlobal) {
                // if we don't add this then it will not correctly update the sum
                // since some elements can be bigger than the sum itself ...
                maxGlobal = maxSum;
            }
        }
        return maxGlobal;
    }
}
