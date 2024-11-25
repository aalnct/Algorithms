package leetcode.top_150;

public class RemoveDuplicateSortedArray {
    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,3};
        print(nums,nums.length);

        removeDuplicates(nums);
        print(nums,nums.length);
    }

    private static int removeDuplicates(int [] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int j = 0; // pointer for unique elements
        int count = 1; // count of occurrences for current elements

        for(int i=1; i < nums.length; i++) {
            if(nums[i] != nums[j]) {
                count = 1;
                j++;
                nums[j] = nums[i];
            } else {
                if(count < 2) {
                    count++;
                    j++;
                    nums[j] = nums[i];
                }
            }
        }
        return j + 1;
    }

    private static void print(int [] nums, int length) {
        for(int i=0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
