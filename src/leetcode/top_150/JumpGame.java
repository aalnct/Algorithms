package leetcode.top_150;

public class JumpGame {
    public static void main(String[] args) {
        int [] nums  = {2,3,1,1,4};
        System.out.println(jumpGame(nums));
    }

    private static boolean jumpGame(int [] nums) {
        int far = 0;
        for(int i=0; i < nums.length; i++) {
            if (i > far) {
                return false;
            }
            far = Math.max(far, i + nums[i]);
        }
        return true;
    }
}