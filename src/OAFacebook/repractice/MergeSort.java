package OAFacebook.repractice;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int [] array = {12, 11, 13, 5, 6, 7};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void mergeSort(int [] array) {
        int n = array.length;
        if (n <= 1) { // base case , if array has 0 or 1 element, that is already sorted ...
            return;
        }
        int mid = n/2; // find the mid point

        int [] leftArray = Arrays.copyOfRange(array,0,mid);
        int [] rightArray = Arrays.copyOfRange(array,mid, n);

        mergeSort(leftArray); // recurssivley the left subarray
        mergeSort(rightArray); // recurssivley sort the right subarray

        merge(array,leftArray,rightArray);
    }

    static void merge(int [] result, int[] leftArray, int [] rightArray) {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;
        int i = 0, j = 0, k = 0;


        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                result[k++] = leftArray[i++];
            } else {
                result[k++] = rightArray[j++];
            }
        }

        // if any element left in left array
        while (i < leftLength) {
            result[k++] = leftArray[i++];
        }

        // similarly for right array
        while (j < rightLength) {
            result[k++] = rightArray[j++];
        }
    }
}
