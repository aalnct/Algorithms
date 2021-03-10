package fb;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {

    public static void main(String[] args) {
        int[] arr1 = {2,3,3,5,5,6,7,7,8,12};
        int[] arr2 = {5,5,6,8,8,9,10,10};
        //Integer[] arr3 = intersectionArray(arr1,arr2);
        /*for(int s : arr3) {
            System.out.println(s);
        }*/

        Integer[] arr3 = intersectionArrayUsingTwoPointer(arr1,arr2);

        for (int s : arr3)
            System.out.println(s);
    }

    static Integer[] intersectionArray(int [] ar1, int[] ar2) {
        Set<Integer> ar1Set = new HashSet<>();
        Set<Integer> ar2Set = new HashSet<>();

        for (int i=0;i<ar1.length;i++) {
            ar1Set.add(ar1[i]);
        }

        for (int i=0;i<ar2.length;i++) {
            ar2Set.add(ar2[i]);
        }

        ar2Set.retainAll(ar1Set);

        Integer[] arr = Arrays.copyOf(ar2Set.toArray(), ar2Set.size(), Integer[].class);

        // String [] ar3 = new String[ar2Set.size()];

        // ar2Set.toArray(ar3);

        return arr;
    }


    static Integer[] intersectionArrayUsingTwoPointer(int[] ar1, int [] ar2) {
        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();
        while (i<ar1.length && j < ar2.length ) {
            if (ar1[i] == ar2[j]) {
                set.add(ar1[i]);
                i++;
                j++;
            } else if (ar1[i] < ar2[j]) {
                ++i;
            } else {
                ++j;
            }
        }
        Integer[] arr = Arrays.copyOf(set.toArray(), set.size(), Integer[].class);


        return arr;
    }
}
