package ds.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AmitAgarwal on 6/8/20.
 */
public class ContainsDuplicate2 {

    public static void main(String[] args) {
        int [] a = new int[] {1,2,3,1};
        int k = 3;
        //boolean result = containsDuplicate(a,k);
        boolean result1 = containsDuplicate2(a,k);
        System.out.println(result1);
    }

    public static boolean containsDuplicate(int[] a, int k){
        a = new int[] {1,2,3,1,2,3};
        k = 2;

        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i] == a[j] && (Math.abs(i-j) <= k)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[]a, int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(map.containsKey(a[i])){
                int lIndex = map.get(a[i]);
                if(i-lIndex <= k){
                    return true;
                }
            }
            map.put(a[i],i);
        }
        return false;
    }
}
