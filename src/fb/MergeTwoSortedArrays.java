package fb;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int [] array1 = {1,2,3,0,0,0};
        int [] array2 = {2,5,6};
        int[] resultArray = twoSortedArrays(array1,array2);
        for (int i : resultArray) System.out.println(i);

         array1 = new int[]{1,2,3,0,0,0};
         array2 = new int[]{2,5,6};

        twoSortedArraysWithDoublePointers(array1,array2);
    }

    static int[] twoSortedArrays(int[] array1, int[] array2){
        int pointer = array1.length-1; // we will start from end of this array
        for (int i=0;i<pointer;i++) {
            if (array1[i] <= array2[i]) {
                array1[pointer] = array2[i];
                pointer--;
            } else {
                array1[pointer] = array1[i];
                pointer--;
            }
        }
        // data is now in array1
        Arrays.sort(array1); // O(nlogn)
        return array1;
    }

    static int[] twoSortedArraysWithDoublePointers(int[] array1, int[] array2 ) {
        int len1 = array2.length-1;
        int len2 = array2.length-1;

        int pointer = array1.length-1;

        int i = 0;
        int j = 0;

        while (len1 >= 0 && len2 >= 0) {
            if (array1[len1] < array2[len2]) {
                array1[pointer] = array2[len2];
                pointer--;
                len2--;
            } else {
                array1[pointer] = array1[len2];
                pointer--;
                len1--;
            }
        }

        while (len2 >= 0) {
            array2[pointer] = array1[len1];
            pointer--;
            len2--;
        }

        while (len1 >= 0) {
            array1[pointer] = array1[len2];
            pointer--;
            len1--;
        }

        return array1;

    }


}
