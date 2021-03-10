package ds.leetcode;

import java.util.*;

public class FindDuplicateInArray {

    private static int[] array = {1,2,3,3,4,5,5,6};

    private static  Set<Integer> findDuplicate (int[] array) {
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> duplicate = new HashMap<>();
        for (int i=0; i <array.length; i++) {
            duplicate.put(array[i], duplicate.getOrDefault(array[i], 0)+1);
        }

        for (int i=0;i<array.length;i++) {
            if (duplicate.get(array[i]) >=2) {
                set.add(array[i]);
            }
        }

        return set;
    }

    public static void main(String[] args) {
        Set<Integer> a = findDuplicate(array);
        for (Integer i : a) {
            System.out.println(i);
        }
    }
}
