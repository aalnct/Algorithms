package OAFacebook;

public class RemoveDuplicate {


    public static void main(String[] args) {
        int [] array = {1,1,2};
        System.out.println(removeDuplicate(array));
    }

    static int removeDuplicate (int [] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }
}
