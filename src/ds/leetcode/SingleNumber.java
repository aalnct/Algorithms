package ds.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AmitAgarwal on 5/28/20.
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2,2,1};
        int result = singleNumber(nums);
        System.out.println(result);
    }

    public static int singleNumber(int[] nums){
        int[] a = {4,1,2,1,2};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(map.containsKey(a[i])){
                map.put(a[i], map.get(a[i])+1);
            }else {
                map.put(a[i], 0);
            }
        }

        for(int a1 : a){
            if(map.get(a1) == 0){
                return a1;
            }
        }

        return 0;
    }
}
