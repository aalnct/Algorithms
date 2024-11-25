package OAOracle;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int [] array = {1,-1,3,2,9,5};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    static void quickSort (int [] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array,low,high);

            // recursively call quick sort
            quickSort(array,low,pivot-1);
            quickSort(array,pivot+1, high);
        }
    }

    static int partition (int [] array, int low, int high) {
        int pivot = array[high]; // last element is pivot ...
        int i = low -1; // index of smaller element ...

        for (int j= low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }

        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i+1;
    }
}
