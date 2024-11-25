package Sorting;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int [] array = {10, 3, 76, 34, 23, 32};
        System.out.println(findKthLargestElement(array,6));
    }

    private static int findKthLargestElement (int [] array, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(); // it will compare the element added, and store them in non-decreasing priority
        for (int i=0; i< array.length; i++) {
            maxHeap.add(array[i]);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
