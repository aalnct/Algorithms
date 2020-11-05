package ds.leetcode.maycodingchallenge;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by AmitAgarwal on 5/16/20.
 */
public class MajorityElement {
    public static void main(String[] args) {
        /*int[] nums = new int[]{3,2,3};*/
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int element = majorityElement(nums);
        System.out.println(element);
    }

    public static int majorityElement(int [] nums){
        int n = nums.length/2;
        int element = 0;
        Map<Integer,Integer> arrayMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(!arrayMap.containsKey(nums[i])){
                arrayMap.put(nums[i],1); // first value will be zero, this is a counter
            }
            else {
                arrayMap.put(nums[i], arrayMap.get(nums[i])+1);
            }
        }

        arrayMap.forEach((k,v) -> System.out.println("Total occurrence for key  :" + k + " is :" + v));

        for(int i = 0;i< nums.length;i++){
            if(arrayMap.get(nums[i]) > n){
                element = nums[i];
            }
        }

        return element;
    }
}
