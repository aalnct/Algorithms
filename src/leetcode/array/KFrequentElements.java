package leetcode.array;

import java.util.*;

public class KFrequentElements {

    public static void main(String[] args) {
        int [] array = {1, 1, 1, 2, 2, 3};
        int k = 2;

        List<Integer> top = frequentElements(array,k);
        System.out.println(top);
    }

    private static List<Integer> frequentElements (int [] array, int k) {
        // Step 1: count the frequency of each element
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for (int a : array) {
            frequencyMap.put(a, frequencyMap.getOrDefault(a,0)+1);
        }

        // now use priority queue (min heap) to keep track
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get));

        for (int a : frequencyMap.keySet()) {
            minHeap.add(a);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove the last element from the heap
            }
        }

        // build a result list from the min heap
        List<Integer> topK = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            topK.add(minHeap.poll());
        }
        Collections.reverse(topK);

        return topK;
    }
}
