package ds.leetcode.array;

import java.util.*;

/**
 * Created by AmitAgarwal on 6/26/20.
 */
public class ArrayWithStackOperations {

    public static void main(String[] args) {
        int[] array = new int[] {1,3};
        int target = 3;
        buildArray(array,target).forEach(l-> System.out.println(l));
    }

    public static List<String> buildArray(int[] array, int target) {
        List<String> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<array.length;i++){
            set.add(array[i]);
        }

        for(int i=1;i<target;i++){
            list.add("push");
            if(!set.contains(i)){
                list.add("pop");
            }
            if(i==array[array.length-1]){
                break;
            }
        }
        return list;
    }
}
