package leetcode.top_150;

/**
 * Remove duplicate from array in-place
 */
public class RemoveDuplicate {
    public static void main(String[] args) {
        int [] nums= {1,1,2,2,3,4,5,5};
        System.out.println(removeDuplicate(nums));
    }

    private static int removeDuplicate(int [] nums) {
        int slow = 0;

         if(nums.length == 0) return 0;

         for(int fast = 1; fast < nums.length; fast++) {
             if(nums[fast] != nums[slow]) {
                 slow++;
                 nums[slow] = nums[fast];
             }
         }
        return ++slow;
    }
}
