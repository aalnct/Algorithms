package leetcode.top_150;

public class MajorityElement {
    public static void main(String[] args) {
        int [] nums = {3,3,4,2,4,4,2,4,4};
        System.out.println(majorityElement(nums));
    }

    private static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for(int num : nums) {
            if(count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // validate
        count = 0;
        for(int num : nums) {
            if(candidate == num) {
                count++;
            }
        }
        return (count > nums.length/2) ? candidate : -1;
    }
}
