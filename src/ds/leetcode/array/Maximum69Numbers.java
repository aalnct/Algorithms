package ds.leetcode.array;

public class Maximum69Numbers {

    public static void main(String[] args) {
        int num = maximum69Numbers(9669);
        System.out.println(num);
    }

    public static int maximum69Numbers (int num) {
        // convert to character array first
        char[] nums = String.valueOf(num).toCharArray();
        for (int i=0; i < nums.length;i++) {
            if (nums[i] == '6') {
                // if we want to get the maximum, change at the start
                // there is no need to change the 9 to 6
                nums[i] = '9';
                return Integer.valueOf(String.valueOf(nums));
            }
        }
        return num;
    }
}
