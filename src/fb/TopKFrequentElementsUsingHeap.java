package fb;

import java.util.*;

public class TopKFrequentElementsUsingHeap {

    public static void main(String[] args) {
        int [] array = new int[] {1,1,1,2,2,3,3,3};
        int k = 2;
        int[] resultArray = topKFrequentElements(array,k);

        for (int ii : resultArray) System.out.println(ii);
    }

    static int[] topKFrequentElements(int[] array, int k) {
        if (k == array.length) {
            return array;
        }

        Map<Integer,Integer> map = new HashMap<>();

        for (int n : array) {
            map.put(n, map.getOrDefault(n,0)+1);
        }

        // less frequent element first

        Queue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(map::get));

        // keep k top frequent elements in the heap
        // O(N log K) < O(N log N)
        for (int n : map.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // output array
        int [] topK = new int[k];
        for (int i = k-1; i >= 0; --i) {
            topK[i] = heap.poll();
        }

        return topK;
    }
}
