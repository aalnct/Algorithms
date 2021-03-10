package practice.sorting;

public class QuickSort {

    int [] array;

    public QuickSort (int [] array) {
        this.array = array;
    }

    public void quickSort (int [] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array,begin,end);
             quickSort(array,0,partitionIndex-1);
             quickSort(array,partitionIndex+1,end);
        }
    }

    // begin - 0
    // end - length -1;
    private int partition(int [] array, int begin,int end) {
        int pivot = array[end]; // pivot is end value of array
        int i = begin-1; // i starts from -1 index

        for (int j=begin; j < end; j++) {
            if (array[j] <= pivot) {
                i++;

                //swap
                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }
        int swapTemp = array[i+1];
        array[i+1] = array[end];
        array[end] = swapTemp;

        return i+1;
    }

    // helper method
    public void print (int [] array) {
        for (int i=0; i< array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
