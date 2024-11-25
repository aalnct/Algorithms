package learingcontinue;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int [] array1 = new int [] {1, 2, 3, 0, 0, 0};
        int [] array2 = new int [] {1,9,8};
        //mergeSortedArray(array1,array2, array2.length, array1.length);
        System.out.println(Arrays.toString(array1));

        array1 = new int [] {1,2,3,0,0,0};
        array2 = new int [] {2,5,6};
        mergeSortedArrays(array1, 3, array2, 3);
        System.out.println("second array " + Arrays.toString(array1));

        array1 = new int [] {1,2,3,0,0,0};
        array2 = new int [] {2,5,6};
        int [] result = mergeSortedArraysNonDecreasing(array1, array2, 3, 3);
        System.out.println(" third array :: " + Arrays.toString(result));

        array1 = new int [] {1,2,3,0,0,0};
        array2 = new int [] {2,5,6};
        merge(array1,3, array2, 3);
        System.out.println("fourth array " + Arrays.toString(array1));
        System.out.println();

    }

    private static void mergeSortedArray(int [] array1, int [] array2, int n, int m) {
        int i = 0;
        int j = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                // replace the element of array 1 at current index with the element of second array at current index
                array1[i] = array2[j];
                j++;
            } else {
                i++;
            }
        }

        // copy remaining elements from second array to first array
        for (int k = j; k < array2.length; k++) {
            array1[i++] = array2[k];
        }
    }


    // non-decreasing
    private static void mergeSortedArrays(int[] array1, int m, int[] array2, int n) {
        int i = 0; // 1,2,3,0,0,0
        int j = 0; // 2, 5, 6

        while (i < m && j < n) {
            if (array1[i] <= array2[j]) { // 1 <= 2 , // 2 <= 2 , // 3 <= 2 , // 3 <=5
                i++; // true, i++ --> 1 , i++ --> 2 , false , true i++ --> 3
            } else {
                array1[i] = array2[j]; // 1, 2, 2, 3
                j++; // j --> 1
            }
        }

        for (int k = j; k < array2.length; k++) { //5, 6
            array1[i++] = array2[k];
        }
    }

    private static final int []  mergeSortedArraysNonDecreasing(int [] array1, int [] array2, int m, int n) {
        int [] result = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (array1[i] < array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }

        while (i < m) {
            result[k++] = array1[i++];
        }
        while (j < n) {
            result[k++] = array2[j++];
        }

        return result;
    }

    public static void merge(int [] array1, int m , int [] array2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while (i >=0 && j >=0) {
            if (array1[i] > array2[j]) {
                array1[k--] = array1[i--];
            } else {
                array1[k--] = array2[j--];
            }
        }

        while (j >= 0) {
            array1[k--] = array2[j--];
        }
    }

}
