package ds.leetcode;

/**
 * Created by AmitAgarwal on 5/6/20.
 */
public class TwoSum {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     */

    private int[] returnIndices(int[] num, int target){
        if(num.length == 0){
            return num;
        }
        for(int i=0;i<num.length;i++){
            for(int j=i+1;j<num.length;j++){
                if(target == num[i] + num[j]){
                    return new int[] {i,j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] num = {2,7,11,15,4,8,13,49};
        int target = 64;
        TwoSum twoSum = new TwoSum();
        int[] n = twoSum.returnIndices(num,target);
        if (n.length != 0) {
            for(int i=0;i<n.length;i++){
                System.out.println(n[i]);
            }
        }else {
            System.out.println("Not Possible");
        }



        n = twoSum(num,target);
        for(int i=0;i<n.length;i++){
            System.out.println( "second solution : " + n[i]);
        }
    }


    private static int[] twoSum(int[] nums, int target){
        int aPointer = 0; //start of array
        int bPointer = nums.length-1;  // end of array

        while(aPointer <= bPointer){
            int sum = nums[aPointer] + nums[bPointer];

            if(sum < target){
                aPointer++;
            }else if(sum > target){
                bPointer--;
            }else {
                return new int[] {aPointer+1,bPointer+1};
            }
        }

        return new int[] {aPointer+1,bPointer+1};
    }

}
