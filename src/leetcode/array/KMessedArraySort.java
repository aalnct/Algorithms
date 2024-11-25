package leetcode.array;

import java.util.PriorityQueue;

/**
 *
 */
public class KMessedArraySort {

    public static void main(String[] args) {
        int [] array = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
        int k = 2;

        System.out.println(" Original Array !!! ");
        for (int a : array) {
            System.out.print ( " " + a);
        }
        System.out.println( );

        System.out.println("After sorting ... ");
        sortedArray(array,k);

        for (int a : array) {
            System.out.print( " " + a);
        }
    }

    private static void sortedArray (int [] array, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // for the first k elements in array
        for (int i=0; i <= k && i < array.length; i++) {
            minHeap.add(array[i]);
        }

        int index = 0;

        // for each element in array starting from k+1
        for (int i = k+1; i < array.length; i++) {
            array[index++] = minHeap.poll(); // extract minimum element from heap and place it in correct position in array
            minHeap.add(array[i]);
        }

        // remaining element in heap
        while (!minHeap.isEmpty()) {
            array[index++] = minHeap.poll();
        }
    }

}
