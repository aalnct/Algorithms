package Sorting;

/**
 * Created by AmitAgarwal on 5/17/19.
 */
public class QuickSort {


    public static void quickSorting(int [] array, int start, int end){
        if(start <  end){
            int partition = partition(array, start, end);
            quickSorting(array,start,partition-1);
            quickSorting(array,partition+1,end);
        }

    }

    private static int partition(int[] array, int start, int end){
        int pivot = array[end]; //setting the pivot element as the last element of an Array
        int i = start-1; //i will start from -1

        for(int j=start;j <= end-1;j++){
            if(array[j] <= pivot){
                i++;
                /**
                 * Swap values b/w i and j
                 */
                int iVal = array[i];
                int jVal = array[j];

                array[j] = iVal;
                array[i] = jVal;
            }
        }

        /**
         * placing the pivot value to the correct slot
         */
        int iVal = array[i+1];
        array[end] = iVal;
        array[i+1] = pivot;

        return i+1;
    }
}
