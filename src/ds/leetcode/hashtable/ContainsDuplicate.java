package ds.leetcode.hashtable;

import java.util.HashMap;

/**
 * Created by AmitAgarwal on 6/8/20.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {

    }

    public static boolean containsDuplicate(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i < nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }

        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i]) > 1){
                return true;
            }
        }
        return false;
    }

}
