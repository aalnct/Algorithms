package ds.leetcode.array;

/**
 * Created by AmitAgarwal on 6/16/20.
 */

/**
 * find number with length as even
 */
public class FindNumbers {

    public static void main(String[] args) {
        int[] nums = new int[] {555,901,4825,1771};
        int result = findNumbers(nums);
        System.out.println(result);
    }

    public static int findNumbers(int[] nums){
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(String.valueOf(nums[i]).length() %2 == 0){
                count++;
            }
        }
        return count;
    }
}
