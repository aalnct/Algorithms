public class FindMissingNumber  {

    public static void main(String[] args) {
        int nums [] = {1,2,3,4,5,6,7,8,9,10,11,12,14};
        int result = findMissingNumber(nums);
        int finalResult = nums[nums.length-1] + result;
        System.out.println(finalResult);
    }

    static int findMissingNumber (int [] nums) {
        int n = nums.length;
        int expectedSum = (n * (n+1))/2;

        int actualSum = 0;

        for (int num : nums) {
            actualSum +=num;
        }

        int missingNumber = expectedSum - actualSum;

        return missingNumber;
    }
}

