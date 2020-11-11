package practice.sorting;

import java.util.Random;

public class MergeSort {
    int [] array;
    int [] temp; // temp array where values will be stored during merging
    private boolean isSorted = false;

    public MergeSort (int [] array) {
        this.array = array;
        this.temp = new int[array.length];
    }

    // merge srt - divide and conquere
    // left and right subarray
        // left - 0 --> middle index -- (low+high)/2
        //right - middleIndex+1 --> high
    //merge them both

    public void mergeSort (int _low, int _high) {
        if (_low >= _high) return;
        int middleIndex = (_low + _high)/2;

        mergeSort(_low, middleIndex);
        mergeSort( middleIndex+1 ,  _high);

        // merge both the right and left subarray

        merge(_low, middleIndex, _high);
    }

    public void print () {
        for(int i=0; i< array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }

    private void merge (int _low, int middle, int _high) {
        for (int i=0; i < array.length; i++) {
            temp[i] = array[i];
        }

        int i = _low;
        int j= middle + 1;
        int k = _low;

        while ( (i<=middle) && (j<=_high)) {
            if(temp[i] <= temp[j]) {
                array[k]  = temp[i];
                i++;
            }else {
                array[k]  = temp[j];
                j++;
            }
            k++;
        }

        // copy left subarray into target array
        while (i <= middle){
            array[k] = temp[i];
            i++;
            k++;
        }
        while (j <= _high) {
            array[k] = temp[j];
            j++;
            k++;
        }
    }

    public boolean isSorted (int [] array) {
        for (int i=0; i < array.length-1;i++){
            if(array[i] < array[i+1]) {
                isSorted = true;
                return isSorted;
            }
        }
        return isSorted;
    }

}
