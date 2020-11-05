package threading;

public class MergeSortThreading {

    private int[] array;
    private int[] temp; // since merge sort is not in place, we need a temp array to store values

    public MergeSortThreading (int[] array) {
        this.array = array;
        temp  = new int[array.length];
    }

    // parallel merge sorting technique

    public void parallelMergeSort(int low, int high, int numOfThreads) {
        if(numOfThreads <= 1) {
            mergeSort(low,high);
            return;
        }
        int middleIndex = (low + high)/2;

        Thread left = mergeSortParallel(low,middleIndex,numOfThreads);
        Thread right = mergeSortParallel(middleIndex+1,high,numOfThreads);

        left.start();
        right.start();

        // wait for each other to finish
        try {
            left.join();
            right.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // finally merge
        merge(low,middleIndex,high);
    }

    private Thread mergeSortParallel(int low, int high, int numOfThreads) {
        return new Thread() {
            @Override
            public void run() {
                parallelMergeSort(low,high,numOfThreads/2);
            }
        };
    }

    // divide part
    public void mergeSort (int low, int high) {
        if(low >= high) {
            return;
        }

        int middleIndex = (low + high)/2;

        // calling recursively
        mergeSort(low,middleIndex);
        mergeSort(middleIndex+1, high);

        // conquere part
        merge(low, middleIndex, high);
    }

    public void print () {
        for(int i=0; i< array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }

    private void merge(int low, int middleIndex, int high) {
        for(int i=0; i< array.length; i++) {
            temp[i] = array[i];
        }
        int i = low; // left subarray
        int j = middleIndex + 1; //right subarray
        int k = low; // final array low value index

        while((i<=middleIndex) && (j<=high)){
            if(temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            }else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }

        // copy remaining left subarray into target array
        while(i <= middleIndex) {
            array[k] = temp[i];
            k++;
            i++;
        }

        // copy remaining right subarray into target array
        while(j <= high) {
            array[k] = temp[j];
            k++;
            j++;
        }
    }

    // helper method to check if array is sorted or not

    public boolean isSorted (int [] array) {
        for(int i=0; i< array.length -1; i++) {
            if(array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }
}
