package OAFacebook.repractice;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int [] array = {1,-1,9,3,0,7};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void quickSort(int[] array) {
        int low = 0;
        int high = array.length-1;

        quickSort(array,low,high);
    }
    static void quickSort(int [] array, int low, int high) {
        if (low < high) {
            int partition = partition(array,low,high);
            quickSort(array,low, partition-1);
            quickSort(array,partition+1,high);
        }
    }

    static int partition (int [] array, int low, int high) {
        int pivot = array[high]; // last element as pivot
        int i = low-1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // swap
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        // final swap
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i+1;
    }
}
