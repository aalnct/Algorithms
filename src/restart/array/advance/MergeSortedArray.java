package restart.array.advance;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        System.out.println(Arrays.toString(mergeSortedArray(arr1,arr2)));
    }

    static int [] mergeSortedArray (int [] array1, int [] array2) {
        int len1 = array1.length;
        int len2 = array2.length;

        int [] merged = new int[len1 + len2];

        int i = 0 ,j = 0 ,k = 0;

        while (i < len1 && j < len2) {
            if (array1[i] <= array2[j]) {
                merged[k++] = array1[i++];
            } else {
                merged[k++] = array2[j++];
            }
        }

        // rest of the elements from array 1
        while (i < len1) {
            merged[k++] = array1[i++];
        }

        // same for array 2
        while (j < len2) {
            merged[k++] = array2[j++];
        }

        return merged;
    }
}
