package ds.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by AmitAgarwal on 5/31/20.
 */
public class UniqueOccurence {

    public static void main(String[] args) {
        int [] nums = new int[] {1,2,2,0,1,3};
        boolean result = uniqueOccurence(nums);
        System.out.println(result);
    }

    public static boolean uniqueOccurence(int[] array) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i]) + 1);
            }else {
                map.put(array[i], 1);
            }
        }

        for(int i : map.keySet()){
            if(set.contains(map.get(i))){
                return false;
            }else {
                set.add(map.get(i));
            }
        }
        return true;
    }
}