package fb;

import java.util.HashSet;
import java.util.Set;

public class ThreeArrayIntersection {

    public static void main(String[] args) {
        int[] array1 = {1};
        int[] array2 = {1,2,5,7,9};
        int[] array3 = {1,3,4,5,8};

        int []  a = threeArrayIntersection(array1,array2,array3);
        for (int i : a) {
            System.out.println(i);
        }
    }

    static int[] threeArrayIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Set<Integer> setArray = new HashSet<>();

        int p = 0;
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                setArray.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[setArray.size()];
        // so setArray will contain common element on arr1 and arr2
        for (int k = 0; k < arr3.length;k++) {
            if(setArray.contains(arr3[k])){
                result[p] = arr3[k];
                p++;
            }
        }
        return result;
    }
}
