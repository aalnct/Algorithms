package threading;

import java.util.Random;

public class MergeSortThreadTest {
    public static void main(String[] args) {
        int numOfThreads = Runtime.getRuntime().availableProcessors();
        int [] nums = new int[] {4,2,6,5,44,78,-4,0,1} ;
        MergeSortThreading mergeSortThreadingParallel = new MergeSortThreading(nums);
        System.out.println("Number of Threads :" + numOfThreads);
        mergeSortThreadingParallel.parallelMergeSort(0,nums.length-1,numOfThreads);
        mergeSortThreadingParallel.print();
        System.out.println(mergeSortThreadingParallel.isSorted(nums));

        System.out.println("************************");

        Random random = new Random();

        int [] array = new int[30];

        for(int j=0; j < array.length; j++) {
            array[j] = random.nextInt(1000) - 500;
        }

        MergeSortThreading mergeSortThreading = new MergeSortThreading(array);

        // find the space and time complexity for merge sort
        mergeSortThreading.mergeSort(0,array.length-1);
        mergeSortThreading.print();
        System.out.println(mergeSortThreading.isSorted(array));
    }
}
